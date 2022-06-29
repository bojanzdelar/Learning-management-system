import { Injectable } from '@angular/core';
import { Thesis } from '@models/thesis.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class ThesisService extends RestService<Thesis> {
  override url: string = `${this.url}/faculty-service/theses`;
}
