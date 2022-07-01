export interface EntityAttribute {
  key: string;
  name: string;
  type: string;
  required?: boolean;
  display?: DisplayFn;
  footer?: FooterAgg;
  options?: { [key: string]: any };
  filteredOptions?: { [key: string]: any };
}

interface DisplayFn {
  (row: any): string;
}

interface FooterAgg {
  (data: any, key: string): any;
}
