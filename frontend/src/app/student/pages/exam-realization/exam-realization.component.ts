import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import {
  ExamRealization,
  getStatusDisplay,
} from '@core/models/exam-realization.model';
import { getSubjectEnrollmentSubjectDisplay } from '@core/models/subject-enrollment.model';
import { ExamRealizationService } from '@core/services/exam-realization.service';
import { getExamTermWithoutSubjectDisplay } from '@core/models/exam-term.model';
import { AuthService } from '@core/services/auth.service';
import { BaseComponent } from '@shared/directives/base-component';
import { TableData } from '@core/models/table-data.model';

@Component({
  selector: 'app-exam-realizations',
  templateUrl: './exam-realization.component.html',
  styleUrls: ['./exam-realization.component.scss'],
})
export class ExamRealizationComponent
  extends BaseComponent<ExamRealization>
  implements OnInit
{
  title: string = 'Exam realizations';
  name: string = 'exam realization';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'subjectEnrollment',
      name: 'Subject',
      type: 'skip',
      display: getSubjectEnrollmentSubjectDisplay,
    },
    {
      key: 'examTerm',
      name: 'Exam term',
      type: 'skip',
      display: getExamTermWithoutSubjectDisplay,
    },
    {
      key: 'score',
      name: 'Score',
      type: 'skip',
    },
    {
      key: 'passed',
      name: 'Status',
      type: 'skip',
      display: getStatusDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: ExamRealizationService,
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
}
