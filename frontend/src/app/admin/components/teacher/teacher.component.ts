import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Teacher } from '@core/models/teacher.model';
import { getUserDisplay } from '@core/models/user.model';
import { TeacherService } from '@core/services/teacher.service';
import { UserService } from '@core/services/user.service';

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
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: TeacherService,
    public userService: UserService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
    this.getOptions('user', this.userService);
  }
}
