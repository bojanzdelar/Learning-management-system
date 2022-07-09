import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export const SelectionRequiredValidator: ValidatorFn = (
  control: AbstractControl
): ValidationErrors | null => {
  return typeof control?.value !== 'object' ? { matchRequired: true } : null;
};
