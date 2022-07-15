import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Student } from '@core/models/student.model';
import { getUserDisplay } from '@core/models/user.model';
import { getSubjectWithStudyProgramDisplay } from '@core/models/subject.model';
import { StudentService } from '@core/services/student.service';
import { SubjectService } from '@core/services/subject.service';
import { AuthService } from '@core/services/auth.service';
import { BaseComponent } from '@shared/directives/base-component';
import { TableSelect } from '@core/models/table-select.model';
import { TableData } from '@core/models/table-data.model';
import format from 'xml-formatter';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss'],
})
export class StudentComponent extends BaseComponent<Student> implements OnInit {
  title: string = 'Students';
  name: string = 'student';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'user',
      name: 'Username',
      type: 'skip',
      display: getUserDisplay,
    },
    {
      key: 'firstName',
      name: 'First name',
      type: 'skip',
    },
    {
      key: 'lastName',
      name: 'Last name',
      type: 'skip',
    },
    {
      key: 'index',
      name: 'Index',
      type: 'skip',
    },
    {
      key: 'yearOfEnrollment',
      name: 'Year of enrollment',
      type: 'skip',
    },
    {
      key: 'averageGrade',
      name: 'Average grade',
      type: 'skip',
      sortable: false,
    },
    {
      key: 'totalECTS',
      name: 'Total ECTS',
      type: 'skip',
      sortable: false,
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
    public override service: StudentService,
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

  exportPdf() {
    if (!this.tableData.select) return;

    this.service
      .getBySubjectIdAllPdf(this.tableData.select)
      .subscribe((data) => {
        saveAs(data, 'students-on-subject.pdf');
      });
  }

  exportXml() {
    if (!this.tableData.select) return;

    this.service
      .getBySubjectIdAllXml(this.tableData.select)
      .subscribe((data) => {
        saveAs(new Blob([format(data)]), 'students-on-subject.xml');
      });
  }
}
