import { Base } from './base.model';
import { ExamPeriod, getExamPeriodDisplay } from './exam-period.model';
import { Exam, getExamDisplay, getExamNameDisplay } from './exam.model';

export interface ExamTerm extends Base {
  startTime: Date;
  endTime: Date;
  exam: Exam;
  examPeriod: ExamPeriod;
}

export function getExamTermDisplay(examTerm: ExamTerm): string {
  if (!examTerm) return '';

  return `${getExamDisplay(examTerm.exam)} - ${getExamPeriodDisplay(
    examTerm.examPeriod
  )}`;
}

export function getExamTermWithoutSubjectDisplay(examTerm: ExamTerm): string {
  if (!examTerm) return '';

  return `${getExamNameDisplay(examTerm.exam)} - ${getExamPeriodDisplay(
    examTerm.examPeriod
  )}`;
}
