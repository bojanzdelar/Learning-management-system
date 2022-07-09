import { Injectable } from '@angular/core';
import { Administrator } from '@core/models/administrator.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class AdministratorService extends RestService<Administrator> {
  override url: string = `${this.url}/faculty-service/administrators`;
}
