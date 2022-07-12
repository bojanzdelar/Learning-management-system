import { Injectable } from '@angular/core';
import { ExamTerm } from '@core/models/exam-term.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class ExamTermService extends RestService<ExamTerm> {
  override url: string = `${this.url}/exam-service/exam-terms`;

  getBySubjectIdAll(id: number): Observable<ExamTerm[]> {
    return this.http.get<ExamTerm[]>(`${this.url}/subject/${id}/all`);
  }

  getByTeacherUsernameAll(username: string): Observable<ExamTerm[]> {
    return this.http.get<ExamTerm[]>(`${this.url}/teacher/${username}/all`);
  }
}
