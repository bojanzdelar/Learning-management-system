import { Base } from '@models/base.model';
import { Page } from '@models/page.model';
import { PageRequest } from '@models/page-request.model';
import { RestService } from '@services/rest.service';
import { DialogFormComponent } from '@components/dialog-form/dialog-form.component';
import { MatDialog } from '@angular/material/dialog';
import { DialogDeleteComponent } from '@components/dialog-delete/dialog-delete.component';
import { EntityAttribute } from '@models/entity-attribute.model';

export abstract class BaseComponent<T extends Base> {
  abstract name: string;
  abstract attributes: EntityAttribute[];

  service: RestService<T>;
  dialog: MatDialog;

  data: Page<T>;
  selected: T;
  pageRequest: PageRequest;

  findAttribute(key: string): EntityAttribute | undefined {
    return this.attributes.find((attribute) => attribute.key === key);
  }

  getPage(request?: PageRequest) {
    request !== undefined
      ? (this.pageRequest = request)
      : (request = this.pageRequest);

    this.service.getPage(request).subscribe((data) => {
      this.data = data;
    });
  }

  getOptions(attributeKey: string, service: RestService<any>) {
    const attribute = this.findAttribute(attributeKey);
    if (!attribute) {
      return;
    }

    service.getAll().subscribe((arr) => {
      const options: any = {};
      arr.forEach((el) => {
        const option: any = {};
        option['data'] = el;
        if (attribute.display) {
          option['display'] = attribute.display(el);
        }
        options[el.id] = option;
      });
      attribute.options = options;
    });
  }

  create() {
    this.openForm();
  }

  select(value: T) {
    const newValue = { ...value };
    this.format(newValue);
    this.selected = newValue;
    this.openForm(this.selected);
  }

  format(value: any) {
    this.attributes
      .filter((attribute) => attribute.type === 'select')
      .forEach((attribute) => {
        const formattedValue: any = {};
        formattedValue['data'] = value[attribute.key];
        if (attribute.display) {
          formattedValue['display'] = attribute.display(value[attribute.key]);
        }
        value[attribute.key] = formattedValue;
      });
  }

  openForm(value?: T) {
    const dialogRef = this.dialog.open(DialogFormComponent, {
      data: {
        name: this.name,
        attributes: this.attributes,
        value: value,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.process(result);
      }
    });
  }

  process(value: T) {
    value.id
      ? this.service.update(value.id, value).subscribe(() => {
          this.getPage();
        })
      : this.service.create(value).subscribe(() => {
          this.getPage();
        });
  }

  delete(ids: number[]) {
    if (!ids.length) {
      window.alert('No rows are selected!');
      return;
    }

    const dialogRef = this.dialog.open(DialogDeleteComponent);
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.service.delete(ids).subscribe(() => {
          this.getPage();
        });
      }
    });
  }
}
