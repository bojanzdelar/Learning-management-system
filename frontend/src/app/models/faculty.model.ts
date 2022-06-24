import { Base } from './base.model';
import { Teacher } from '@models/teacher.model';
import { Address } from '@models/address.model';

export interface Faculty extends Base {
  name: string;
  description: string;
  email: string;
  dean: Teacher;
  address: Address;
}

export function getFacultyDisplay(faculty: Faculty): string {
  return faculty.name;
}
