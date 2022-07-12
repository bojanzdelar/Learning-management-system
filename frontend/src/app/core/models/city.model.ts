import { Base } from './base.model';
import { Country, getCountryDisplay } from './country.model';

export interface City extends Base {
  name: string;
  country: Country;
}

export function getCityDisplay(city: City): string {
  if (!city) return '';

  return `${city.name}, ${getCountryDisplay(city.country)}`;
}
