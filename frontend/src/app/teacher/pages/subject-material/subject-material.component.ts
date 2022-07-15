import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { SubjectMaterial } from '@core/models/subject-material.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { getSubjectWithStudyProgramDisplay } from '@core/models/subject.model';
import { SubjectService } from '@core/services/subject.service';
import { SubjectMaterialService } from '@core/services/subject-material.service';
import { formatDateTime } from '@shared/utils/utility';
import { TableSelect } from '@core/models/table-select.model';
import { AuthService } from '@core/services/auth.service';
import { TableData } from '@core/models/table-data.model';

@Component({
  selector: 'app-subject-material',
  templateUrl: './subject-material.component.html',
  styleUrls: ['./subject-material.component.scss'],
})
export class SubjectMaterialComponent
  extends BaseComponent<SubjectMaterial>
  implements OnInit
{
  title: string = 'Subject materials';
  name: string = 'subject material';
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
      key: 'resourceUrl',
      name: 'Resource URL',
      type: 'text',
      required: true,
    },
    {
      key: 'publicationDate',
      name: 'Publication date',
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
    public override service: SubjectMaterialService,
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

  override process(value: SubjectMaterial): void {
    value.subject = this.table.selectForm.value;
    super.process(value);
  }
}
