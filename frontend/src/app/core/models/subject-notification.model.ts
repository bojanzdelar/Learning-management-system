import { Base } from './base.model';
import { Teacher } from './teacher.model';
import { Subject } from './subject.model';

export interface SubjectNotification extends Base {
  name: string;
  description: string;
  publicationDate: Date;
  teacher: Teacher;
  subject: Subject;
}

export function getSubjectNotificationDisplay(
  subjectNotification: SubjectNotification
): string {
  if (!subjectNotification) return '';

  return subjectNotification.name;
}
