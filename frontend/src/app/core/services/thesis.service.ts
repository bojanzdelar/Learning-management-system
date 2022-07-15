import { Injectable } from '@angular/core';
import { Thesis } from '@core/models/thesis.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class ThesisService extends RestService<Thesis> {
  override url: string = `${this.url}/faculty-service/theses`;

  getByStudentId(id: number): Observable<Thesis> {
    return this.http.get<Thesis>(`${this.url}/student/${id}`);
  }
}
