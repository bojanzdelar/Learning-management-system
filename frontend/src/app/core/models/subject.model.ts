import { Base } from './base.model';
import { StudyProgram } from './study-program.model';
import { Teacher } from './teacher.model';

export interface Subject extends Base {
  name: string;
  syllabus: string;
  semester: number;
  ects: number;
  studyProgram: StudyProgram;
  professor: Teacher;
  assistant: Teacher;
}

export function getSubjectDisplay(subject: Subject): string {
  return subject.name;
}
