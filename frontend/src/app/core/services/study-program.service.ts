import { Injectable } from '@angular/core';
import { StudyProgram } from '@core/models/study-program.model';
import { Observable } from 'rxjs';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class StudyProgramService extends RestService<StudyProgram> {
  override url: string = `${this.url}/faculty-service/study-programs`;

  getByFacultyId(id: number): Observable<StudyProgram[]> {
    return this.http.get<StudyProgram[]>(`${this.url}/faculty/${id}/all`);
  }
}
