import { Directive, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Base } from '@core/models/base.model';
import { Page } from '@core/models/page.model';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { RestService } from '@core/services/rest.service';
import { DialogFormComponent } from '@shared/components/dialog-form/dialog-form.component';
import { DialogDeleteComponent } from '@shared/components/dialog-delete/dialog-delete.component';
import { TableComponent } from '@shared/components/table/table.component';
import { TableData } from '@core/models/table-data.model';

@Directive()
export abstract class BaseComponent<T extends Base> {
  abstract title: string;
  abstract name: string;
  abstract attributes: EntityAttribute[];

  service: RestService<T>;
  dialog: MatDialog;

  data: Page<T>;
  selected: T;
  tableData: TableData;

  @ViewChild(TableComponent) table: TableComponent<T>;

  findAttribute(key: string): EntityAttribute | undefined {
    return this.attributes.find((attribute) => attribute.key === key);
  }

  getPage(data?: TableData) {
    data !== undefined ? (this.tableData = data) : (data = this.tableData);

    this.service.getPage(data?.request).subscribe((data) => {
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

  edit(value: T) {
    const newValue = { ...value };
    this.format(newValue);
    this.selected = newValue;
    this.openForm(this.selected);
  }

  format(value: any) {
    this.attributes
      .filter((attribute) => attribute.type === 'select')
      .forEach((attribute) => {
        if (!value[attribute.key]) {
          return;
        }

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
    delete value['ids'];
    value.id
      ? this.service.update(value.id, value).subscribe({
          next: () => {
            this.getPage();
          },
          error: () => {
            window.alert('Something went wrong! Please try again');
          },
        })
      : this.service.create(value).subscribe({
          next: () => {
            this.getPage();
          },
          error: () => {
            window.alert('Something went wrong! Please try again');
          },
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
          this.table.clearSelection();
        });
      }
    });
  }
}
