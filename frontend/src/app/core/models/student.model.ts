import { Base } from './base.model';
import { User } from './user.model';
import { Thesis } from './thesis.model';
import { StudyProgram } from './study-program.model';

export interface Student extends Base {
  user: User | string;
  firstName: string;
  lastName: string;
  index: string;
  yearOfEnrollment: number;
  thesis: Thesis;
  studyProgram: StudyProgram;
}

export function getStudentDisplay(student: Student): string {
  return `${student.firstName} ${student.lastName}`;
}
