import { Injectable } from '@angular/core';
import { Exam } from '@core/models/exam.model';
import { Page } from '@core/models/page.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class ExamService extends RestService<Exam> {
  override url: string = `${this.url}/exam-service/exams`;

  getBySubjectIdAll(id: number): Observable<Exam[]> {
    return this.http.get<Exam[]>(`${this.url}/subject/${id}/all`);
  }

  getBySubjectId(id: number, params?: any): Observable<Page<Exam>> {
    return this.http.get<Page<Exam>>(`${this.url}/subject/${id}`, {
      params,
    });
  }
}
