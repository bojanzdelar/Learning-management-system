import { Component, Inject, OnInit } from '@angular/core';
import {
  ControlContainer,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Base } from '@core/models/base.model';
import { DialogData } from '@core/models/dialog-data.model';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { SelectionRequiredValidator } from '@shared/utils/selection-required-validator';

@Component({
  selector: 'app-dialog-form',
  templateUrl: './dialog-form.component.html',
  styleUrls: ['./dialog-form.component.scss'],
})
export class DialogFormComponent<T extends Base> implements OnInit {
  name: string;
  attributes: EntityAttribute[];

  form: FormGroup = new FormGroup({
    id: new FormControl(null),
  });

  ids: any = {};

  constructor(
    @Inject(MAT_DIALOG_DATA) data: DialogData<T>,
    public dialogRef: MatDialogRef<DialogFormComponent<T>>
  ) {
    this.name = data.name;

    // Attributes for FormGroup generation
    this.attributes = data.attributes.filter(
      (attribute: EntityAttribute) =>
        attribute.type !== 'id' &&
        !(attribute.type === 'password' && data.value)
    );

    this.attributes.forEach((attribute) => {
      const formControl: FormControl = new FormControl(null);

      attribute.required && formControl.addValidators([Validators.required]);
      attribute.type === 'select' &&
        formControl.addValidators([SelectionRequiredValidator]);
      attribute.type === 'password' &&
        formControl.addValidators([Validators.minLength(6)]);
      attribute.validators && formControl.addValidators(attribute.validators);

      this.form.addControl(attribute.key, formControl);

      if (attribute.options) {
        attribute.filteredOptions = { ...attribute.options };
      }
    });

    const value: any = data.value;
    if (value) {
      this.attributes.forEach((attribute) => {
        if (attribute.type === 'text' && attribute.display) {
          this.ids[attribute.key] = value[attribute.key].id;
          value[attribute.key] = attribute.display(value[attribute.key]);
        }
      });

      this.form.patchValue(value);
    }

    // Attributes for HTML generation
    this.attributes = this.attributes.filter(
      (attribute: EntityAttribute) => attribute.type !== 'skip'
    );
  }

  ngOnInit(): void {
    this.dialogRef.updateSize('100vw');
  }

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
      let invalid = false;
      for (let key in this.form.controls) {
        const control = this.form.controls[key];

        if (control.invalid) {
          if (!control.hasValidator(Validators.required) && !control.value) {
            continue;
          }

          invalid = true;
          control.markAsTouched();
        }
      }

      if (invalid) return;
    }

    const value = this.form.value;

    this.attributes
      .filter((attribute) => attribute.type === 'select')
      .forEach((attribute) => {
        value[attribute.key] = value[attribute.key].data;
      });

    this.ids && (value.ids = this.ids);
    this.dialogRef.close(value);
  }
}
