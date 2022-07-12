import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { ExamRealization } from '@core/models/exam-realization.model';
import { getSubjectEnrollmentStudentDisplay } from '@core/models/subject-enrollment.model';
import { getExamTermDisplay } from '@core/models/exam-term.model';
import { ExamRealizationService } from '@core/services/exam-realization.service';
import { ExamTermService } from '@core/services/exam-term.service';
import { AuthService } from '@core/services/auth.service';
import { BaseComponent } from '@shared/directives/base-component';
import { TableSelect } from '@core/models/table-select.model';
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
      name: 'Student',
      type: 'skip',
      display: getSubjectEnrollmentStudentDisplay,
    },
    {
      key: 'score',
      name: 'Score',
      type: 'number',
      required: true,
    },
  ];

  tableSelect: TableSelect = {
    observable: this.examTermService.getByTeacherUsernameAll(
      this.authService.getUsername()
    ),
    display: getExamTermDisplay,
  };

  constructor(
    public override dialog: MatDialog,
    public override service: ExamRealizationService,
    public examTermService: ExamTermService,
    public authService: AuthService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
  }

  override getPage(data?: TableData) {
    data !== undefined ? (this.tableData = data) : (data = this.tableData);
    if (!data?.select) return;

    this.service
      .getByExamTermId(data.select, data?.request)
      .subscribe((data) => {
        this.data = data;
      });
  }
}
