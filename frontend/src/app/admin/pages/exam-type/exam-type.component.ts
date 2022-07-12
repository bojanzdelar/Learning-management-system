import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { ExamType } from '@core/models/exam-type.model';
import { ExamTypeService } from '@core/services/exam-type.service';

@Component({
  selector: 'app-exam-type',
  templateUrl: './exam-type.component.html',
  styleUrls: ['./exam-type.component.scss'],
})
export class ExamTypeComponent
  extends BaseComponent<ExamType>
  implements OnInit
{
  title: string = 'Exam types';
  name: string = 'exam type';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'name',
      name: 'Name',
      type: 'text',
      required: true,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: ExamTypeService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
  }
}
