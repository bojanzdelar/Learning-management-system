import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '@core/services/auth.service';

@Injectable()
export class RequestInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (
      this.authService.accessToken &&
      !request.url.includes('/auth-service/refresh')
    ) {
      const newRequest = request.clone({
        headers: request.headers.set(
          'Authorization',
          `Bearer ${this.authService.accessToken}`
        ),
      });

      return next.handle(newRequest);
    }

    return next.handle(request);
  }
}
