import { Base } from './base.model';
import { getUserDisplay, User } from '@models/user.model';
import { Thesis } from './thesis.model';
import { StudyProgram } from './study-program.model';

export interface Student extends Base {
  user: User;
  index: string;
  yearOfEnrollment: number;
  thesis: Thesis;
  studyProgram: StudyProgram;
}

export function getStudentDisplay(student: Student): string {
  return getUserDisplay(student.user);
}
