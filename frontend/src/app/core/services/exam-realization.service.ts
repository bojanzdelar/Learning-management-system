import { Injectable } from '@angular/core';
import { ExamRealization } from '@core/models/exam-realization.model';
import { Page } from '@core/models/page.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class ExamRealizationService extends RestService<ExamRealization> {
  override url: string = `${this.url}/exam-service/exam-realizations`;

  getByExamTermId(id: number, params?: any): Observable<Page<ExamRealization>> {
    return this.http.get<Page<ExamRealization>>(`${this.url}/exam-term/${id}`, {
      params,
    });
  }
}
