import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { SubjectTerm } from '@core/models/subject-term.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { getSubjectWithStudyProgramDisplay } from '@core/models/subject.model';
import { SubjectTermService } from '@core/services/subject-term.service';
import { SubjectService } from '@core/services/subject.service';
import { formatDateTime } from '@shared/utils/utility';
import { TableSelect } from '@core/models/table-select.model';
import { AuthService } from '@core/services/auth.service';
import { TableData } from '@core/models/table-data.model';

@Component({
  selector: 'app-subject-term',
  templateUrl: './subject-term.component.html',
  styleUrls: ['./subject-term.component.scss'],
})
export class SubjectTermComponent
  extends BaseComponent<SubjectTerm>
  implements OnInit
{
  title: string = 'Subject terms';
  name: string = 'subject term';
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
      key: 'description',
      name: 'Description',
      type: 'lob',
      required: true,
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
      key: 'teacher',
      name: 'Teacher',
      type: 'skip',
      display: getTeacherDisplay,
    },
  ];

  tableSelect: TableSelect = {
    observable: this.subjectService.getByTeacherId(
      this.authService.getTeacherId()
    ),
    display: getSubjectWithStudyProgramDisplay,
  };

  constructor(
    public override dialog: MatDialog,
    public override service: SubjectTermService,
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

  override process(value: SubjectTerm): void {
    value.subject = this.table.selectForm.value;
    super.process(value);
  }
}
