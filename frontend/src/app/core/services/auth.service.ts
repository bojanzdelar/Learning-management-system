import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Token } from '@core/models/token.model';
import { User } from '@core/models/user.model';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private url: string = `${environment.baseUrl}/auth-service/login`;

  token: any;
  user: any;

  public redirectUrl: string | undefined;

  constructor(private http: HttpClient, private router: Router) {
    this.token = localStorage.getItem('token');
    if (this.token) {
      this.user = JSON.parse(atob(this.token.split('.')[1]));
    }
  }

  getUsername(): string {
    return this.user.sub;
  }

  getUserId(): number {
    return this.user.userId;
  }

  getStudentId(): number {
    return this.user.studentId;
  }

  getTeacherId(): number {
    return this.user.teacherId;
  }

  getAdminId(): number {
    return this.user.adminId;
  }

  hasTokenExpired(): boolean {
    return this.user.exp < Date.now() / 1000;
  }

  loggedIn(): boolean {
    return this.user;
  }

  login(user: User): Observable<Token> {
    const request = this.http.post<Token>(this.url, user);

    request.subscribe({
      next: (token: Token) => {
        this.token = token.token;
        this.user = JSON.parse(atob(this.token.split('.')[1]));
        localStorage.setItem('token', token.token);
        if (this.redirectUrl) {
          this.router.navigate([this.redirectUrl]);
          this.redirectUrl = undefined;
        } else {
          this.router.navigate(['/']);
        }
      },
      error: () => {},
    });

    return request;
  }

  logout() {
    this.token = null;
    this.user = null;
    localStorage.removeItem('token');
    this.router.navigate(['/']);
  }

  validateRoles(roles: any, method = 'any') {
    if (!this.token || !['any', 'all'].includes(method)) return false;

    if (method == 'any')
      return roles.some((role: any) => this.user.roles.includes(role));

    if (method == 'all')
      return roles.every((role: any) => this.user.roles.includes(role));
  }
}
