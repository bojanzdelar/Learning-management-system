import { Base } from './base.model';
import { City, getCityDisplay } from './city.model';

export interface Address extends Base {
  street: string;
  number: number;
  city: City;
}

export function getAddressDisplay(address: Address): string {
  if (!address) return '';

  return `${address.street} ${address.number}, ${getCityDisplay(address.city)}`;
}
