import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import {
  BehaviorSubject,
  catchError,
  Observable,
  switchMap,
  throwError,
  filter,
  take,
} from 'rxjs';
import { AuthService } from '@core/services/auth.service';

@Injectable()
export class ResponseInterceptor implements HttpInterceptor {
  private isRefreshing = false;
  private refreshTokenSubject: BehaviorSubject<any> = new BehaviorSubject<any>(
    null
  );

  constructor(private authService: AuthService) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError((err) => {
        if (
          this.authService.loggedIn() &&
          this.authService.hasTokenExpired() &&
          !request.url.includes('/auth-service/refresh')
        ) {
          return this.handleTokenExpired(request, next);
        }
        return throwError(() => err);
      })
    );
  }

  private handleTokenExpired(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (!this.isRefreshing) {
      this.isRefreshing = true;
      this.refreshTokenSubject.next(null);
      const token = this.authService.refreshToken;
      if (token) {
        return this.authService.refresh().pipe(
          switchMap((token: any) => {
            this.isRefreshing = false;
            this.authService.saveAccessToken(token.accessToken);
            this.refreshTokenSubject.next(token.accessToken);
            return next.handle(this.addTokenHeader(request, token.accessToken));
          }),
          catchError((err) => {
            this.isRefreshing = false;
            this.authService.logout();
            return throwError(() => err);
          })
        );
      }
    }

    return this.refreshTokenSubject.pipe(
      filter((token) => token !== null),
      take(1),
      switchMap((token) => next.handle(this.addTokenHeader(request, token)))
    );
  }

  private addTokenHeader(request: HttpRequest<any>, token: string) {
    return request.clone({
      headers: request.headers.set('Authorization', 'Bearer ' + token),
    });
  }
}
