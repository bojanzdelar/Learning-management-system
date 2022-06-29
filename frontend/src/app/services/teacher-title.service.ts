import { Injectable } from '@angular/core';
import { TeacherTitle } from '@models/teacher-title.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class TeacherTitleService extends RestService<TeacherTitle> {
  override url: string = `${this.url}/faculty-service/teacher-titles`;
}
