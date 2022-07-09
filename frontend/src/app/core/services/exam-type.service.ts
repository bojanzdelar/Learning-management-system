import { Injectable } from '@angular/core';
import { ExamType } from '@core/models/exam-type.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class ExamTypeService extends RestService<ExamType> {
  override url: string = `${this.url}/exam-service/exam-types`;
}
