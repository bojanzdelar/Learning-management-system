import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Tokens } from '@core/models/tokens.model';
import { User } from '@core/models/user.model';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private url: string = `${environment.baseUrl}/auth-service`;

  accessToken: any;
  refreshToken: any;
  user: any;

  public redirectUrl: string | undefined;

  constructor(private http: HttpClient, private router: Router) {
    this.accessToken = localStorage.getItem('accessToken');
    this.refreshToken = localStorage.getItem('refreshToken');
    if (!this.accessToken && !this.refreshToken) {
      return;
    }

    this.setUserFromToken();
    if (this.hasTokenExpired()) {
      this.refresh();
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

  saveAccessToken(token: string) {
    this.accessToken = token;
    this.setUserFromToken();
    localStorage.setItem('accessToken', token);
  }

  saveRefreshToken(token: string) {
    this.refreshToken = token;
    localStorage.setItem('refreshToken', token);
  }

  setUserFromToken() {
    if (!this.accessToken) {
      return;
    }

    this.user = JSON.parse(atob(this.accessToken.split('.')[1]));
  }

  loggedIn(): boolean {
    return this.user;
  }

  login(user: User): Observable<Tokens> {
    const request = this.http.post<Tokens>(`${this.url}/login`, user);

    request.subscribe({
      next: (tokens: Tokens) => {
        this.saveAccessToken(tokens.accessToken);
        this.saveRefreshToken(tokens.refreshToken);

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

  refresh() {
    return this.http.get<Tokens>(`${this.url}/refresh`, {
      headers: { Authorization: `Bearer ${this.refreshToken}` },
    });
  }

  logout() {
    this.accessToken = null;
    this.refreshToken = null;
    this.user = null;
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
    this.router.navigate(['/']);
  }

  validateRoles(roles: any, method = 'any') {
    if (!this.accessToken || !['any', 'all'].includes(method)) return false;

    if (method == 'any')
      return roles.some((role: any) => this.user.roles.includes(role));

    if (method == 'all')
      return roles.every((role: any) => this.user.roles.includes(role));
  }
}
