import { Injectable } from '@angular/core';
import { Student } from '@core/models/student.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class StudentService extends RestService<Student> {
  override url: string = `${this.url}/faculty-service/students`;
}
