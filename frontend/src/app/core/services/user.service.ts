import { Injectable } from '@angular/core';
import { User } from '@core/models/user.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class UserService extends RestService<User> {
  override url: string = `${this.url}/auth-service/users`;

  getIdByUsername(username: string): Observable<number> {
    return this.http.get<number>(`${this.url}/username/${username}/id`);
  }
}
