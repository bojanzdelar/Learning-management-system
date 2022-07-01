import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { PageRequest } from '@core/models/page-request.model';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Page } from '@core/models/page.model';
import { Base } from '@core/models/base.model';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent<T extends Base> implements OnInit {
  @Input()
  title: string;

  @Input()
  set columns(attributes: EntityAttribute[]) {
    attributes = attributes.filter(
      (attribute: EntityAttribute) => attribute.type !== 'lob'
    );

    this.columnProps = attributes;
    this.columnKeys = [
      'select',
      ...attributes.map((attribute) => attribute.key),
      'actions',
    ];
  }

  @Input()
  set data(data: Page<T>) {
    if (!data) return;

    this.dataSource.data = data.content;
    this.paginator.length = data.totalElements;
    this.paginator.pageIndex = data.number;
  }

  @Input()
  defaultPageSize: number = 20;

  @Output()
  changeDataEvent: EventEmitter<PageRequest> = new EventEmitter();

  @Output()
  createEvent: EventEmitter<T> = new EventEmitter();

  @Output()
  editEvent: EventEmitter<T> = new EventEmitter();

  @Output()
  deleteEvent: EventEmitter<number[]> = new EventEmitter();

  dataSource = new MatTableDataSource<T>();
  selection = new SelectionModel<T>(true, []);
  searchTerm: string = '';

  columnProps: EntityAttribute[];
  columnKeys: string[];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor() {}

  ngOnInit() {
    this.selection.isSelected = this.isChecked.bind(this);
  }

  isComplexType(attribute: EntityAttribute): boolean {
    return attribute.display !== undefined;
  }

  isChecked(row: any): boolean {
    return (
      this.selection.selected.find((el: T) => el.id === row.id) !== undefined
    );
  }

  clearSelection() {
    this.selection.clear();
  }

  makeSearch(search: string) {
    this.searchTerm = search;
    this.paginator.pageIndex = 0;
    this.makeRequest();
  }

  makeRequest() {
    const request: PageRequest = {
      search: this.searchTerm,
      page: this.paginator.pageIndex,
      size: this.paginator.pageSize,
    };
    if (this.sort.direction) {
      request.sort = `${this.sort.active},${this.sort.direction}`;
    }

    this.changeDataEvent.emit(request);
  }

  create() {
    this.createEvent.emit();
  }

  edit(row: T) {
    this.editEvent.emit(row);
  }

  delete() {
    const ids: number[] = [];
    this.selection.selected.forEach(
      (el: T) => el.id !== undefined && ids.push(el.id)
    );
    this.deleteEvent.emit(ids);
  }
}
