import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { StudyProgram } from '@core/models/study-program.model';
import { getFacultyDisplay } from '@core/models/faculty.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { StudyProgramService } from '@core/services/study-program.service';
import { FacultyService } from '@core/services/faculty.service';
import { TeacherService } from '@core/services/teacher.service';

@Component({
  selector: 'app-study-program',
  templateUrl: './study-program.component.html',
  styleUrls: ['./study-program.component.scss'],
})
export class StudyProgramComponent
  extends BaseComponent<StudyProgram>
  implements OnInit
{
  title: string = 'Study programs';
  name: string = 'study program';
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
      key: 'faculty',
      name: 'Faculty',
      type: 'select',
      required: true,
      display: getFacultyDisplay,
    },
    {
      key: 'manager',
      name: 'Manager',
      type: 'select',
      required: true,
      display: getTeacherDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: StudyProgramService,
    public facultyService: FacultyService,
    public teacherService: TeacherService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
    this.getOptions('faculty', this.facultyService);
    this.getOptions('manager', this.teacherService);
  }
}
