import { Base } from './base.model';
import { User } from './user.model';

export interface Administrator extends Base {
  user: User | string;
  firstName: string;
  lastName: string;
}

export function getAdministratorDisplay(administrator: Administrator): string {
  if (!administrator) return '';

  return `${administrator.firstName} ${administrator.lastName}`;
}
