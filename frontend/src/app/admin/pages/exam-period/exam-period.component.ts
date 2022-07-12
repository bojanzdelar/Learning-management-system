import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { ExamPeriod } from '@core/models/exam-period.model';
import { getFacultyDisplay } from '@core/models/faculty.model';
import { ExamPeriodService } from '@core/services/exam-period.service';
import { FacultyService } from '@core/services/faculty.service';

@Component({
  selector: 'app-exam-period',
  templateUrl: './exam-period.component.html',
  styleUrls: ['./exam-period.component.scss'],
})
export class ExamPeriodComponent
  extends BaseComponent<ExamPeriod>
  implements OnInit
{
  title: string = 'Exam periods';
  name: string = 'exam period';
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
    {
      key: 'registrationStartDate',
      name: 'Registration start date',
      type: 'date',
      required: true,
    },
    {
      key: 'registrationEndDate',
      name: 'Registration end date',
      type: 'date',
      required: true,
    },
    {
      key: 'examStartDate',
      name: 'Exam start date',
      type: 'date',
      required: true,
    },
    {
      key: 'examEndDate',
      name: 'Exam end date',
      type: 'date',
      required: true,
    },
    {
      key: 'faculty',
      name: 'Faculty',
      type: 'select',
      required: true,
      display: getFacultyDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: ExamPeriodService,
    public facultyService: FacultyService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
    this.getOptions('faculty', this.facultyService);
  }
}
