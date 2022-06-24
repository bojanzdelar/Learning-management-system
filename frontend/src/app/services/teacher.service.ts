import { Injectable } from '@angular/core';
import { Teacher } from '@models/teacher.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class TeacherService extends RestService<Teacher> {
  override url: string = `${this.url}/faculty-service/teachers`;
}
