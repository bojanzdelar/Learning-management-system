import { Base } from './base.model';

export interface User extends Base {
  username: string;
}

export function getUserDisplay(user: User): string {
  return user.username;
}
