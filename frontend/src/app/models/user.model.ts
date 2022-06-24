import { Base } from './base.model';

export interface User extends Base {
  email: string;
  firstName: string;
  lastName: string;
}

export function getUserDisplay(user: User): string {
  return `${user.firstName} ${user.lastName}`;
}
