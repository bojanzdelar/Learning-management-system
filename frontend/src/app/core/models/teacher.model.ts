import { Base } from './base.model';
import { User } from './user.model';

export interface Teacher extends Base {
  user: User | string;
  firstName: string;
  lastName: string;
}

export function getTeacherDisplay(teacher: Teacher): string {
  if (!teacher) return '';

  return `${teacher.firstName} ${teacher.lastName}`;
}
