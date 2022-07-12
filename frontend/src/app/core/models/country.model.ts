import { Base } from './base.model';

export interface Country extends Base {
  name: string;
}

export function getCountryDisplay(country: Country): string {
  if (!country) return '';

  return country.name;
}
