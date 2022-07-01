import { Base } from './base.model';
import { Faculty } from './faculty.model';
import { Teacher } from './teacher.model';

export interface StudyProgram extends Base {
  name: string;
  description: string;
  faculty: Faculty;
  manager: Teacher;
}

export function getStudyProgramDisplay(studyProgram: StudyProgram): string {
  return studyProgram.name;
}
