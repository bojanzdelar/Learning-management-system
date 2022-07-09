import { Base } from './base.model';

export interface Page<T extends Base> {
  content: T[];
  totalElements: number;
  number: number;
}
