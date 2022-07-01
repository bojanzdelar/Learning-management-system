import { Injectable } from '@angular/core';
import { Address } from '@core/models/address.model';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root',
})
export class AddressService extends RestService<Address> {
  override url: string = `${this.url}/faculty-service/addresses`;
}
