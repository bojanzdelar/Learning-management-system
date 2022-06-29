import { Base } from './base.model';

export interface TeacherTitle extends Base {
  title: string;
}

export function getTeacherTitleDisplay(teacherTitle: TeacherTitle): string {
  return teacherTitle.title;
}
