import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@models/entity-attribute.model';
import { Student } from '@models/student.model';
import { getUserDisplay } from '@models/user.model';
import { getThesisDisplay } from '@models/thesis.model';
import { getStudyProgramDisplay } from '@models/study-program.model';
import { StudentService } from '@services/student.service';
import { UserService } from '@services/user.service';
import { ThesisService } from '@services/thesis.service';
import { StudyProgramService } from '@services/study-program.service';

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
      name: 'User',
      type: 'select',
      required: true,
      display: getUserDisplay,
    },
    {
      key: 'index',
      name: 'Index',
      type: 'text',
      required: true,
    },
    {
      key: 'yearOfEnrollment',
      name: 'Year of enrollment',
      type: 'number',
      required: true,
    },
    {
      key: 'thesis',
      name: 'Thesis',
      type: 'select',
      display: getThesisDisplay,
    },
    {
      key: 'studyProgram',
      name: 'Study program',
      type: 'select',
      required: true,
      display: getStudyProgramDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: StudentService,
    public userService: UserService,
    public thesisService: ThesisService,
    public studyProgramService: StudyProgramService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
    this.getOptions('user', this.userService);
    this.getOptions('thesis', this.thesisService);
    this.getOptions('studyProgram', this.studyProgramService);
  }
}
