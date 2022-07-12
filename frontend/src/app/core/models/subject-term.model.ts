import { Base } from './base.model';
import { Teacher } from './teacher.model';
import { Subject } from './subject.model';

export interface SubjectTerm extends Base {
  name: string;
  description: string;
  startTime: Date;
  endTime: Date;
  teacher: Teacher;
  subject: Subject;
}

export function getSubjectTermDisplay(subjectTerm: SubjectTerm): string {
  if (!subjectTerm) return '';

  return subjectTerm.name;
}
