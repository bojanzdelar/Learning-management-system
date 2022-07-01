import { Injectable } from '@angular/core';
import { Faculty } from '@core/models/faculty.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class FacultyService extends RestService<Faculty> {
  override url: string = `${this.url}/faculty-service/faculties`;
}
