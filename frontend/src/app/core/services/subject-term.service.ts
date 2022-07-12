import { Injectable } from '@angular/core';
import { Page } from '@core/models/page.model';
import { SubjectTerm } from '@core/models/subject-term.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class SubjectTermService extends RestService<SubjectTerm> {
  override url: string = `${this.url}/subject-service/subject-terms`;

  getBySubjectIdAll(id: number): Observable<SubjectTerm[]> {
    return this.http.get<SubjectTerm[]>(`${this.url}/subject/${id}/all`);
  }

  getBySubjectId(id: number, params?: any): Observable<Page<SubjectTerm>> {
    return this.http.get<Page<SubjectTerm>>(`${this.url}/subject/${id}`, {
      params,
    });
  }
}
