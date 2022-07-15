import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-import',
  templateUrl: './dialog-import.component.html',
  styleUrls: ['./dialog-import.component.scss'],
})
export class DialogImportComponent implements OnInit {
  name: string;

  form: FormControl = new FormControl(null, [Validators.required]);

  constructor(
    @Inject(MAT_DIALOG_DATA) name: string,
    public dialogRef: MatDialogRef<DialogImportComponent>
  ) {
    this.name = name;
  }

  ngOnInit(): void {
    this.dialogRef.updateSize('100vw');
  }

  confirm() {
    if (this.form.invalid) {
      this.form.markAsTouched();
      return;
    }

    this.dialogRef.close(this.form.value);
  }
}
