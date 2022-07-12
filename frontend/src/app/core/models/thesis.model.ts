import { Base } from './base.model';
import { Student } from './student.model';
import { Teacher } from './teacher.model';

export interface Thesis extends Base {
  name: string;
  description: string;
  url: string;
  applicationDate: Date;
  defenseDate: Date;
  grade: number;
  student: Student;
  mentor: Teacher;
}

export function getThesisDisplay(thesis: Thesis): string {
  if (!thesis) return '';

  return thesis.name;
}
