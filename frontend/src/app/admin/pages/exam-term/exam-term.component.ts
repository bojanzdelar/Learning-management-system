import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { ExamTerm } from '@core/models/exam-term.model';
import { getExamDisplay } from '@core/models/exam.model';
import { getExamPeriodDisplay } from '@core/models/exam-period.model';
import { ExamTermService } from '@core/services/exam-term.service';
import { ExamService } from '@core/services/exam.service';
import { ExamPeriodService } from '@core/services/exam-period.service';
import { formatDateTime } from '@shared/utils/utility';

@Component({
  selector: 'app-exam-term',
  templateUrl: './exam-term.component.html',
  styleUrls: ['./exam-term.component.scss'],
})
export class ExamTermComponent
  extends BaseComponent<ExamTerm>
  implements OnInit
{
  title: string = 'Exam terms';
  name: string = 'exam term';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'startTime',
      name: 'Start time',
      type: 'datetime-local',
      required: true,
      display: formatDateTime,
    },
    {
      key: 'endTime',
      name: 'End time',
      type: 'datetime-local',
      required: true,
      display: formatDateTime,
    },
    {
      key: 'exam',
      name: 'Exam',
      type: 'select',
      required: true,
      display: getExamDisplay,
    },
    {
      key: 'examPeriod',
      name: 'Exam period',
      type: 'select',
      required: true,
      display: getExamPeriodDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: ExamTermService,
    public examService: ExamService,
    public examPeriodService: ExamPeriodService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
    this.getOptions('exam', this.examService);
    this.getOptions('examPeriod', this.examPeriodService);
  }
}
