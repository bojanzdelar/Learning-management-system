import { Injectable } from '@angular/core';
import { Page } from '@core/models/page.model';
import { Student } from '@core/models/student.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class StudentService extends RestService<Student> {
  override url: string = `${this.url}/faculty-service/students`;

  getAllXml(): Observable<string> {
    return this.http.get(`${this.url}/all`, {
      headers: { Accept: 'application/xml' },
      responseType: 'text',
    });
  }

  getAllPdf(): Observable<Blob> {
    return this.http.get(`${this.url}/all/pdf`, { responseType: 'blob' });
  }

  getBySubjectIdAllXml(id: number): Observable<string> {
    return this.http.get(`${this.url}/subject/${id}/all`, {
      headers: { Accept: 'application/xml' },
      responseType: 'text',
    });
  }

  getBySubjectIdAllPdf(id: number): Observable<Blob> {
    return this.http.get(`${this.url}/subject/${id}/all/pdf`, {
      responseType: 'blob',
    });
  }

  getBySubjectId(id: number, params?: any): Observable<Page<Student>> {
    return this.http.get<Page<Student>>(`${this.url}/subject/${id}`, {
      params,
    });
  }

  getThesisId(id: number): Observable<number> {
    return this.http.get<number>(`${this.url}/${id}/thesis/id`);
  }
}
