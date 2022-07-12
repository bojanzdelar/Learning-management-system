import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Thesis } from '@core/models/thesis.model';
import { getStudentDisplay } from '@core/models/student.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { ThesisService } from '@core/services/thesis.service';

@Component({
  selector: 'app-thesis',
  templateUrl: './thesis.component.html',
  styleUrls: ['./thesis.component.scss'],
})
export class ThesisComponent extends BaseComponent<Thesis> implements OnInit {
  title: string = 'Theses';
  name: string = 'thesis';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'name',
      name: 'Name',
      type: 'skip',
    },
    {
      key: 'description',
      name: 'Description',
      type: 'lob',
    },
    {
      key: 'url',
      name: 'URL',
      type: 'skip',
    },
    {
      key: 'applicationDate',
      name: 'Application date',
      type: 'skip',
    },
    {
      key: 'defenseDate',
      name: 'Defense date',
      type: 'skip',
    },
    {
      key: 'grade',
      name: 'Grade',
      type: 'skip',
    },
    {
      key: 'student',
      name: 'Student',
      type: 'skip',
      display: getStudentDisplay,
    },
    {
      key: 'mentor',
      name: 'Mentor',
      type: 'skip',
      display: getTeacherDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: ThesisService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
  }
}
