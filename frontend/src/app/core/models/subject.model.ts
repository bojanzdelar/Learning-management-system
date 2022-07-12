import { Base } from './base.model';
import { getStudyProgramDisplay, StudyProgram } from './study-program.model';
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
  if (!subject) return '';

  return subject.name;
}

export function getSubjectWithStudyProgramDisplay(subject: Subject): string {
  if (!subject) return '';

  return `${subject.name} (${getStudyProgramDisplay(subject.studyProgram)})`;
}
