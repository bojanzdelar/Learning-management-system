import { Observable } from 'rxjs';

export interface TableSelect {
  observable: Observable<any[]>;
  options?: any[];
  filteredOptions?: any[];
  display: (value: any) => string;
}
