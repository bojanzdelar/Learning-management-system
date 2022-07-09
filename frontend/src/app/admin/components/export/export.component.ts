import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-export',
  templateUrl: './export.component.html',
  styleUrls: ['./export.component.scss'],
})
export class ExportComponent implements OnInit {
  @Output()
  exportPdfEvent: EventEmitter<any> = new EventEmitter();

  @Output()
  exportXmlEvent: EventEmitter<any> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  exportPdf(): void {
    this.exportPdfEvent.emit();
  }

  exportXml(): void {
    this.exportXmlEvent.emit();
  }
}
