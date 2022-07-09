import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Subject } from '@core/models/subject.model';
import { getStudyProgramDisplay } from '@core/models/study-program.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { StudyProgramService } from '@core/services/study-program.service';
import { TeacherService } from '@core/services/teacher.service';
import { SubjectService } from '@core/services/subject.service';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss'],
})
export class SubjectComponent extends BaseComponent<Subject> implements OnInit {
  title: string = 'Subjects';
  name: string = 'subject';
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
      key: 'syllabus',
      name: 'Syllabus',
      type: 'lob',
      required: true,
    },
    {
      key: 'semester',
      name: 'Semester',
      type: 'number',
      required: true,
    },
    {
      key: 'ects',
      name: 'ECTS',
      type: 'number',
      required: true,
    },
    {
      key: 'studyProgram',
      name: 'Study program',
      type: 'select',
      required: true,
      display: getStudyProgramDisplay,
    },
    {
      key: 'professor',
      name: 'Professor',
      type: 'select',
      required: true,
      display: getTeacherDisplay,
    },
    {
      key: 'assistant',
      name: 'Assistant',
      type: 'select',
      required: true,
      display: getTeacherDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: SubjectService,
    public studyProgramService: StudyProgramService,
    public teacherService: TeacherService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
    this.getOptions('studyProgram', this.studyProgramService);
    this.getOptions('professor', this.teacherService);
    this.getOptions('assistant', this.teacherService);
  }
}
