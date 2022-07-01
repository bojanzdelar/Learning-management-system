import { Injectable } from '@angular/core';
import { SubjectMaterial } from '@core/models/subject-material.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class SubjectMaterialService extends RestService<SubjectMaterial> {
  override url: string = `${this.url}/subject-service/subject-materials`;

  getBySubjectId(id: number): Observable<SubjectMaterial[]> {
    return this.http.get<SubjectMaterial[]>(`${this.url}/subject/${id}`);
  }
}
