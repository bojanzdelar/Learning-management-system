import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { SubjectEnrollment } from '@core/models/subject-enrollment.model';
import { getStudentDisplay } from '@core/models/student.model';
import { getSubjectWithStudyProgramDisplay } from '@core/models/subject.model';
import { SubjectEnrollmentService } from '@core/services/subject-enrollment.service';
import { SubjectService } from '@core/services/subject.service';
import { AuthService } from '@core/services/auth.service';
import { BaseComponent } from '@shared/directives/base-component';
import { TableSelect } from '@core/models/table-select.model';
import { TableData } from '@core/models/table-data.model';

@Component({
  selector: 'app-subject-enrollment',
  templateUrl: './subject-enrollment.component.html',
  styleUrls: ['./subject-enrollment.component.scss'],
})
export class SubjectEnrollmentComponent
  extends BaseComponent<SubjectEnrollment>
  implements OnInit
{
  title: string = 'Subject enrollments';
  name: string = 'subject enrollment';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'student',
      name: 'Student',
      type: 'skip',
      display: getStudentDisplay,
    },
    {
      key: 'extraPoints',
      name: 'Extra points',
      type: 'number',
    },
    {
      key: 'grade',
      name: 'Grade',
      type: 'number',
    },
  ];

  tableSelect: TableSelect = {
    observable: this.subjectService.getByTeacherUsername(
      this.authService.getUsername()
    ),
    display: getSubjectWithStudyProgramDisplay,
  };

  constructor(
    public override dialog: MatDialog,
    public override service: SubjectEnrollmentService,
    public subjectService: SubjectService,
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
      .getBySubjectId(data.select, data?.request)
      .subscribe((data) => {
        this.data = data;
      });
  }
}
