import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@models/entity-attribute.model';
import { Teacher } from '@models/teacher.model';
import { getUserDisplay } from '@models/user.model';
import { getTeacherTitleDisplay } from '@models/teacher-title.model';
import { TeacherService } from '@services/teacher.service';
import { UserService } from '@services/user.service';
import { TeacherTitleService } from '@services/teacher-title.service';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.scss'],
})
export class TeacherComponent extends BaseComponent<Teacher> implements OnInit {
  title: string = 'Teachers';
  name: string = 'teacher';
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
      key: 'teacherTitle',
      name: 'Teacher title',
      type: 'select',
      required: true,
      display: getTeacherTitleDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: TeacherService,
    public userService: UserService,
    public teacherTitleService: TeacherTitleService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
    this.getOptions('user', this.userService);
    this.getOptions('teacherTitle', this.teacherTitleService);
  }
}
