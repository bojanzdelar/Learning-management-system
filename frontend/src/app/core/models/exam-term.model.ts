import { Base } from './base.model';
import { ExamPeriod } from './exam-period.model';
import { Exam, getExamDisplay } from './exam.model';

export interface ExamTerm extends Base {
  startTime: Date;
  endTime: Date;
  exam: Exam;
  examPeriod: ExamPeriod;
}

export function getExamTermDisplay(examTerm: ExamTerm): string {
  if (!examTerm) return '';

  return `${getExamDisplay(examTerm.exam)} - ${examTerm.examPeriod.name}`;
}
