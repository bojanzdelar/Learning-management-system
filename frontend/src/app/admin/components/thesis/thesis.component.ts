import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Thesis } from '@core/models/thesis.model';
import { getStudentDisplay } from '@core/models/student.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { ThesisService } from '@core/services/thesis.service';
import { StudentService } from '@core/services/student.service';
import { TeacherService } from '@core/services/teacher.service';

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
      type: 'string',
      required: true,
    },
    {
      key: 'description',
      name: 'Description',
      type: 'lob',
    },
    {
      key: 'url',
      name: 'URL',
      type: 'string',
      required: true,
    },
    {
      key: 'applicationDate',
      name: 'Application date',
      type: 'date',
      required: true,
    },
    {
      key: 'defenseDate',
      name: 'Defense date',
      type: 'date',
    },
    {
      key: 'grade',
      name: 'Grade',
      type: 'number',
    },
    {
      key: 'student',
      name: 'Student',
      type: 'select',
      required: true,
      display: getStudentDisplay,
    },
    {
      key: 'mentor',
      name: 'Mentor',
      type: 'select',
      required: true,
      display: getTeacherDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: ThesisService,
    public studentService: StudentService,
    public teacherService: TeacherService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
    this.getOptions('student', this.studentService);
    this.getOptions('mentor', this.teacherService);
  }
}
