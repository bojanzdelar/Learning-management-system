import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-import-export',
  templateUrl: './import-export.component.html',
  styleUrls: ['./import-export.component.scss'],
})
export class ImportExportComponent implements OnInit {
  @Input()
  disabledImport: boolean = false;

  @Input()
  disabledPdfExport: boolean = false;

  @Input()
  disabledXmlExport: boolean = false;

  @Output()
  importEvent: EventEmitter<void> = new EventEmitter();

  @Output()
  uploadEvent: EventEmitter<void> = new EventEmitter();

  @Output()
  exportPdfEvent: EventEmitter<void> = new EventEmitter();

  @Output()
  exportXmlEvent: EventEmitter<void> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  import(): void {
    this.importEvent.emit();
  }

  upload(): void {
    this.uploadEvent.emit();
  }

  exportPdf(): void {
    this.exportPdfEvent.emit();
  }

  exportXml(): void {
    this.exportXmlEvent.emit();
  }
}
