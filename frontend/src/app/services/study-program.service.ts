import { Injectable } from '@angular/core';
import { StudyProgram } from '@models/study-program.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class StudyProgramService extends RestService<StudyProgram> {
  override url: string = `${this.url}/faculty-service/study-programs`;
}
