import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@models/entity-attribute.model';
import { User } from '@models/user.model';
import { UserService } from '@services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
})
export class UserComponent extends BaseComponent<User> implements OnInit {
  title: string = 'Users';
  name: string = 'user';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'email',
      name: 'Email',
      type: 'text',
      required: true,
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
    public override service: UserService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
  }
}
