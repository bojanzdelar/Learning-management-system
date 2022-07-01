import { Injectable } from '@angular/core';
import { City } from '@core/models/city.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class CityService extends RestService<City> {
  override url: string = `${this.url}/faculty-service/cities`;
}
