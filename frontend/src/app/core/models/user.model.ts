import { Base } from './base.model';

export interface User extends Base {
  username: string;
}

export function getUserDisplay(user: User): string {
  if (!user) return '';

  return user.username;
}
