import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Teacher } from '@core/models/teacher.model';
import { getUserDisplay } from '@core/models/user.model';
import { TeacherService } from '@core/services/teacher.service';
import { UserService } from '@core/services/user.service';
import { BaseUserComponent } from '../../directives/base-user-component';
import format from 'xml-formatter';
import { saveAs } from 'file-saver';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.scss'],
})
export class TeacherComponent
  extends BaseUserComponent<Teacher>
  implements OnInit
{
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
      name: 'Username',
      type: 'text',
      required: true,
      display: getUserDisplay,
    },
    {
      key: 'password',
      name: 'Password',
      type: 'password',
      required: true,
      validators: [Validators.minLength(8)],
      errorMessage: 'Password must be at least 8 characters long',
    },
    {
      key: 'firstName',
      name: 'First name',
      type: 'text',
      required: true,
    },
    {
      key: 'lastName',
      name: 'Last name',
      type: 'text',
      required: true,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: TeacherService,
    public override userService: UserService
  ) {
    super(userService);
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
  }

  exportPdf() {
    this.service.getAllPdf().subscribe((data) => {
      saveAs(data, 'teachers.pdf');
    });
  }

  exportXml() {
    this.service.getAllXml().subscribe((data) => {
      saveAs(new Blob([format(data)]), 'teachers.xml');
    });
  }
}
