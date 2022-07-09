import { Base } from './base.model';

export interface ExamType extends Base {
  name: string;
}

export function getExamTypeDisplay(examType: ExamType): string {
  return examType.name;
}
