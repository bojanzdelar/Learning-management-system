import { Injectable } from '@angular/core';
import { Page } from '@core/models/page.model';
import { SubjectMaterial } from '@core/models/subject-material.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class SubjectMaterialService extends RestService<SubjectMaterial> {
  override url: string = `${this.url}/subject-service/subject-materials`;

  getBySubjectIdAll(id: number): Observable<SubjectMaterial[]> {
    return this.http.get<SubjectMaterial[]>(`${this.url}/subject/${id}/all`);
  }

  getBySubjectId(id: number, params?: any): Observable<Page<SubjectMaterial>> {
    return this.http.get<Page<SubjectMaterial>>(`${this.url}/subject/${id}`, {
      params,
    });
  }
}
