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
  averageGrade?: number;
  totalECTS?: number;
}

export function getStudentDisplay(student: Student): string {
  if (!student) return '';

  return `${student.firstName} ${student.lastName}`;
}
