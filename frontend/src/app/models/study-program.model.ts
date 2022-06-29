import { Base } from './base.model';
import { Faculty } from './faculty.model';
import { Teacher } from '@models/teacher.model';

export interface StudyProgram extends Base {
  name: string;
  description: string;
  faculty: Faculty;
  manager: Teacher;
}

export function getStudyProgramDisplay(studyProgram: StudyProgram): string {
  console.log(studyProgram);
  return studyProgram.name;
}
