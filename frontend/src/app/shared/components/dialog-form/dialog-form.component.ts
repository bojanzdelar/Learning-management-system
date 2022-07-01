import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DialogData } from '@core/models/dialog-data.model';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { SelectionRequiredValidator } from '@shared/selection-required-validator';

@Component({
  selector: 'app-dialog-form',
  templateUrl: './dialog-form.component.html',
  styleUrls: ['./dialog-form.component.scss'],
})
export class DialogFormComponent<T> implements OnInit {
  name: string;
  attributes: EntityAttribute[];

  form: FormGroup = new FormGroup({
    id: new FormControl(null),
  });

  constructor(
    @Inject(MAT_DIALOG_DATA) data: DialogData<T>,
    public dialogRef: MatDialogRef<DialogFormComponent<T>>
  ) {
    this.name = data.name;
    this.attributes = data.attributes.filter(
      (attribute: EntityAttribute) => attribute.type !== 'id'
    );

    this.attributes.forEach((attribute) => {
      const formControl: FormControl = new FormControl(null);
      attribute.required && formControl.addValidators([Validators.required]);
      attribute.type === 'select' &&
        formControl.addValidators([SelectionRequiredValidator]);
      this.form.addControl(attribute.key, formControl);

      if (attribute.options) {
        attribute.filteredOptions = { ...attribute.options };
      }
    });

    data.value && this.form.patchValue(data.value);
  }

  ngOnInit(): void {}

  getDisplay(value: any) {
    return value ? value.display : null;
  }

  onAutocompleteKeyUp(searchText: string, attribute: EntityAttribute) {
    if (!attribute.options) {
      return;
    }

    const lowerSearchText = searchText?.toString();
    const filteredOptions: any = {};

    Object.entries(attribute.options).forEach(([key, value]) => {
      if (value.display.toString().toLowerCase().includes(lowerSearchText)) {
        filteredOptions[key] = value;
      }
    });

    attribute.filteredOptions = filteredOptions;
  }

  confirm() {
    if (this.form.invalid) {
      for (let key in this.form.controls) {
        const control = this.form.get(key);
        if (control && control.invalid) {
          control.markAsTouched();
        }
      }
      return;
    }

    const value = this.form.value;

    this.attributes
      .filter((attribute) => attribute.type === 'select')
      .forEach((attribute) => {
        value[attribute.key] = value[attribute.key].data;
      });

    this.dialogRef.close(value);
  }
}
