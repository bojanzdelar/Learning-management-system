import { Injectable } from '@angular/core';
import { ExamPeriod } from '@core/models/exam-period.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class ExamPeriodService extends RestService<ExamPeriod> {
  override url: string = `${this.url}/exam-service/exam-periods`;
}
