import { ValidatorFn } from '@angular/forms';

export interface EntityAttribute {
  key: string;
  name: string;
  type: string;
  required?: boolean;
  sortable?: false;
  display?: DisplayFn;
  footer?: FooterAgg;
  validators?: ValidatorFn[];
  errorMessage?: string;
  options?: { [key: string]: any };
  filteredOptions?: { [key: string]: any };
}

interface DisplayFn {
  (row: any): string;
}

interface FooterAgg {
  (data: any, key: string): any;
}
