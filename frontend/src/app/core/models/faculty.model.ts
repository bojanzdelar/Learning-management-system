import { Base } from './base.model';
import { Teacher } from './teacher.model';
import { Address } from './address.model';

export interface Faculty extends Base {
  name: string;
  description: string;
  email: string;
  dean: Teacher;
  address: Address;
}

export function getFacultyDisplay(faculty: Faculty): string {
  if (!faculty) return '';

  return faculty.name;
}
