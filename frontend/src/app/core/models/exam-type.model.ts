import { Base } from './base.model';

export interface ExamType extends Base {
  name: string;
}

export function getExamTypeDisplay(examType: ExamType): string {
  if (!examType) return '';

  return examType.name;
}
