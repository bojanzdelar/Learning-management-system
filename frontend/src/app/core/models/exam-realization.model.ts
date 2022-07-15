import { Base } from './base.model';
import {
  getSubjectEnrollmentDisplay,
  SubjectEnrollment,
} from './subject-enrollment.model';
import { ExamTerm, getExamTermDisplay } from './exam-term.model';

export interface ExamRealization extends Base {
  subjectEnrollment: SubjectEnrollment;
  examTerm: ExamTerm;
  score: number;
  passed: boolean;
}

export function getExamRealizationDisplay(
  examRealization: ExamRealization
): string {
  if (!examRealization) return '';

  return `${getSubjectEnrollmentDisplay(
    examRealization.subjectEnrollment
  )} - ${getExamTermDisplay(examRealization.examTerm)}`;
}

export function getStatusDisplay(passed: boolean) {
  if (passed === undefined) {
    return '';
  }

  return passed ? 'passed' : 'failed';
}
