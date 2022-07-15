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
import { TableSelect } from '@core/models/table-select.model';
import { FormControl } from '@angular/forms';
import { SelectionRequiredValidator } from '@shared/utils/selection-required-validator';
import { TableData } from '@core/models/table-data.model';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent<T extends Base> implements OnInit {
  @Input()
  title: string;

  @Input()
  disabledCreate: boolean = false;

  @Input()
  disabledSelect: boolean = false;

  @Input()
  set disabledEdit(value: boolean) {
    this._disabledEdit = value;
    this.setColumns(this.columnProps);
  }
  _disabledEdit: boolean = false;

  @Input()
  selectButtonText: string = 'Delete selected';

  @Input()
  selectButtonColor: string = 'warn';

  @Input()
  set columns(attributes: EntityAttribute[]) {
    attributes = attributes.filter(
      (attribute: EntityAttribute) =>
        attribute.type !== 'lob' && attribute.type !== 'password'
    );
    this.columnProps = attributes;
    this.setColumns(this.columnProps);
  }

  @Input()
  set data(data: Page<T>) {
    if (!data) return;

    this.dataSource.data = data.content;
    this.paginator.length = data.totalElements;
    this.paginator.pageIndex = data.number;
  }

  @Input()
  set selectData(data: TableSelect) {
    this.select = data;
    data.observable.subscribe((options: any[]) => {
      this.select.options = [...options];
      this.select.filteredOptions = [...options];
      options.length && this.selectForm.setValue(options[0]);
      this.makeRequest();
    });
  }

  @Input()
  defaultPageSize: number = 20;

  @Output()
  changeDataEvent: EventEmitter<TableData> = new EventEmitter();

  @Output()
  createEvent: EventEmitter<T> = new EventEmitter();

  @Output()
  editEvent: EventEmitter<T> = new EventEmitter();

  @Output()
  selectEvent: EventEmitter<number[]> = new EventEmitter();

  dataSource = new MatTableDataSource<T>();
  selection = new SelectionModel<T>(true, []);
  searchTerm: string = '';

  columnProps: EntityAttribute[];
  columnKeys: string[];

  select: TableSelect;
  selectForm: FormControl = new FormControl(null, [SelectionRequiredValidator]);

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor() {}

  ngOnInit() {
    this.selection.isSelected = this.isChecked.bind(this);
  }

  setColumns(attributes: EntityAttribute[]) {
    if (!attributes) return;

    this.columnKeys = [...attributes.map((attribute) => attribute.key)];
    if (!this.disabledSelect) {
      this.columnKeys = ['select', ...this.columnKeys];
    }
    if (!this._disabledEdit) {
      this.columnKeys = [...this.columnKeys, 'actions'];
    }
  }

  isComplexType(attribute: EntityAttribute): boolean {
    return attribute.display !== undefined || attribute.sortable === false;
  }

  isChecked(row: any): boolean {
    return (
      this.selection.selected.find((el: T) => el.id === row.id) !== undefined
    );
  }

  clearSelection() {
    this.selection.clear();
  }

  onAutocompleteKeyUp(searchText: string) {
    if (!this.select.options) return;

    const lowerSearchText = searchText?.toString();
    const selectOptionsFiltered = this.select.options.filter((option: any) =>
      this.select.display(option).toLowerCase().includes(lowerSearchText)
    );

    this.select.filteredOptions = selectOptionsFiltered;
  }

  getCellContent(column: EntityAttribute, element: T) {
    if (column.options && column.options[element[column.key].id]) {
      return column.options[element[column.key].id].display;
    }

    if (column.display) {
      return column.display(element[column.key]);
    }

    return element[column.key];
  }

  makeSelection() {
    this.searchTerm = '';
    this.makeRequest();
  }

  makeSearch() {
    this.paginator.pageIndex = 0;
    this.makeRequest();
  }

  makeRequest() {
    const request: PageRequest = {
      search: this.searchTerm,
      page: this.paginator?.pageIndex ? this.paginator.pageIndex : 0,
      size: this.paginator?.pageSize
        ? this.paginator.pageSize
        : this.defaultPageSize,
    };
    if (this.sort?.direction) {
      request.sort = `${this.sort.active},${this.sort.direction}`;
    }

    const data: TableData = {
      request,
    };

    if (this.selectForm.value) {
      data['select'] = this.selectForm.value.id;
    }

    this.changeDataEvent.emit(data);
  }

  emitCreate() {
    this.createEvent.emit();
  }

  emitEdit(row: T) {
    this.editEvent.emit(row);
  }

  emitSelect() {
    const ids: number[] = [];
    this.selection.selected.forEach(
      (el: T) => el.id !== undefined && ids.push(el.id)
    );
    this.selectEvent.emit(ids);
  }
}
