import { Base } from './base.model';
import { Faculty } from './faculty.model';

export interface ExamPeriod extends Base {
  name: string;
  registrationStartDate: Date;
  registrationEndDate: Date;
  examStartDate: Date;
  examEndDate: Date;
  faculty: Faculty;
}

export function getExamPeriodDisplay(examPeriod: ExamPeriod): string {
  return examPeriod.name;
}
