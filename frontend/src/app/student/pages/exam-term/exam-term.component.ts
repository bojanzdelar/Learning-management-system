import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { ExamTerm } from '@core/models/exam-term.model';
import { getExamDisplay } from '@core/models/exam.model';
import { getExamPeriodDisplay } from '@core/models/exam-period.model';
import { ExamTermService } from '@core/services/exam-term.service';
import { formatDateTime } from '@shared/utils/utility';
import { TableData } from '@core/models/table-data.model';
import { AuthService } from '@core/services/auth.service';
import { DialogRegisterComponent } from './dialog-register/dialog-register.component';
import { ExamRealizationService } from '@core/services/exam-realization.service';

@Component({
  selector: 'app-exam-term',
  templateUrl: './exam-term.component.html',
  styleUrls: ['./exam-term.component.scss'],
})
export class ExamTermComponent
  extends BaseComponent<ExamTerm>
  implements OnInit
{
  title: string = 'Exam terms registration';
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
      type: 'skip',
      display: formatDateTime,
    },
    {
      key: 'endTime',
      name: 'End time',
      type: 'skip',
      display: formatDateTime,
    },
    {
      key: 'exam',
      name: 'Exam',
      type: 'skip',
      display: getExamDisplay,
    },
    {
      key: 'examPeriod',
      name: 'Exam period',
      type: 'skip',
      display: getExamPeriodDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: ExamTermService,
    public examRealizationService: ExamRealizationService,
    public authService: AuthService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
  }

  override getPage(data?: TableData) {
    data !== undefined ? (this.tableData = data) : (data = this.tableData);

    this.service
      .getByStudentId(this.authService.getStudentId(), data?.request)
      .subscribe((data) => {
        this.data = data;
      });
  }

  register(ids: number[]) {
    if (!ids.length) {
      window.alert('No exam terms are selected!');
      return;
    }

    const dialogRef = this.dialog.open(DialogRegisterComponent);
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.examRealizationService.createByExamTermId(ids).subscribe(() => {
          this.getPage();
          this.table.clearSelection();
        });
      }
    });
  }
}
