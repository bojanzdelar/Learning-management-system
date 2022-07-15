import { Injectable } from '@angular/core';
import { ExamRealization } from '@core/models/exam-realization.model';
import { Page } from '@core/models/page.model';
import { SubjectEnrollment } from '@core/models/subject-enrollment.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class SubjectEnrollmentService extends RestService<SubjectEnrollment> {
  override url: string = `${this.url}/subject-service/subject-enrollments`;

  getBySubjectId(
    id: number,
    params?: any
  ): Observable<Page<SubjectEnrollment>> {
    return this.http.get<Page<SubjectEnrollment>>(`${this.url}/subject/${id}`, {
      params,
    });
  }

  getByStudentId(
    id: number,
    params?: any
  ): Observable<Page<SubjectEnrollment>> {
    return this.http.get<Page<SubjectEnrollment>>(`${this.url}/student/${id}`, {
      params,
    });
  }

  updateGrade(
    id: number,
    value: SubjectEnrollment
  ): Observable<SubjectEnrollment> {
    return this.http.patch<SubjectEnrollment>(`${this.url}/${id}/grade`, value);
  }
}
