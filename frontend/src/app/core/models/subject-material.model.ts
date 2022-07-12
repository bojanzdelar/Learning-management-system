import { Base } from './base.model';
import { Teacher } from './teacher.model';
import { Subject } from './subject.model';

export interface SubjectMaterial extends Base {
  name: string;
  description: string;
  resourceUrl: string;
  publicationDate: Date;
  teacher: Teacher;
  subject: Subject;
}

export function getSubjectMaterialDisplay(
  subjectMaterial: SubjectMaterial
): string {
  if (!subjectMaterial) return '';

  return subjectMaterial.name;
}
