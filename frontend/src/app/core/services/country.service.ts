import { Injectable } from '@angular/core';
import { Country } from '@core/models/country.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class CountryService extends RestService<Country> {
  override url: string = `${this.url}/faculty-service/countries`;
}
