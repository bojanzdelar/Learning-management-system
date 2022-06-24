import { EntityAttribute } from './entity-attribute.model';

export interface DialogData<T> {
  name: string;
  attributes: EntityAttribute[];
  value?: T;
}
