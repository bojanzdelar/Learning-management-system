import {
  AfterViewInit,
  Component,
  ElementRef,
  Inject,
  OnInit,
  ViewChild,
} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-upload',
  templateUrl: './dialog-upload.component.html',
  styleUrls: ['./dialog-upload.component.scss'],
})
export class DialogUploadComponent implements OnInit, AfterViewInit {
  name: string;

  data: any;
  error: boolean = false;

  @ViewChild('fileInput') fileInput: ElementRef;

  constructor(
    @Inject(MAT_DIALOG_DATA) name: string,
    public dialogRef: MatDialogRef<DialogUploadComponent>
  ) {
    this.name = name;
  }

  ngOnInit(): void {
    this.dialogRef.updateSize('100vw');
  }

  ngAfterViewInit(): void {
    const fileInput: HTMLInputElement = this.fileInput.nativeElement;

    this.fileInput.nativeElement.addEventListener('change', () => {
      if (fileInput && fileInput.files && fileInput.files.length > 0) {
        this.loadDataFile(fileInput.files[0]);
        this.error = false;
      } else {
        this.data = null;
        this.error = true;
      }
    });
  }

  loadDataFile(file: File) {
    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.data = e.target.result;
    };
    reader.readAsText(file);
  }

  confirm() {
    if (!this.data) {
      this.error = true;
      return;
    }

    this.dialogRef.close(this.data);
  }
}
