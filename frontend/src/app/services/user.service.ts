import { Injectable } from '@angular/core';
import { User } from '@models/user.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class UserService extends RestService<User> {
  override url: string = `${this.url}/faculty-service/users`;
}
