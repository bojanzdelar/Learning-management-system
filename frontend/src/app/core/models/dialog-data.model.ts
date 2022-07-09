import { Base } from './base.model';
import { EntityAttribute } from './entity-attribute.model';

export interface DialogData<T extends Base> {
  name: string;
  attributes: EntityAttribute[];
  value?: T;
}
