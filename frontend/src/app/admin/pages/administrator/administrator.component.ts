import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Administrator } from '@core/models/administrator.model';
import { getUserDisplay } from '@core/models/user.model';
import { AdministratorService } from '@core/services/administrator.service';
import { UserService } from '@core/services/user.service';
import { BaseUserComponent } from '../../directives/base-user-component';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-administrator',
  templateUrl: './administrator.component.html',
  styleUrls: ['./administrator.component.scss'],
})
export class AdministratorComponent
  extends BaseUserComponent<Administrator>
  implements OnInit
{
  title: string = 'Administrators';
  name: string = 'administrator';
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
    public override service: AdministratorService,
    public override userService: UserService
  ) {
    super(userService);
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
  }
}
