import { Injectable } from '@angular/core';
import { Page } from '@core/models/page.model';
import { SubjectNotification } from '@core/models/subject-notification.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class SubjectNotificationService extends RestService<SubjectNotification> {
  override url: string = `${this.url}/subject-service/subject-notifications`;

  getBySubjectIdAll(id: number): Observable<SubjectNotification[]> {
    return this.http.get<SubjectNotification[]>(
      `${this.url}/subject/${id}/all`
    );
  }

  getBySubjectId(
    id: number,
    params?: any
  ): Observable<Page<SubjectNotification>> {
    return this.http.get<Page<SubjectNotification>>(
      `${this.url}/subject/${id}`,
      {
        params,
      }
    );
  }
}
