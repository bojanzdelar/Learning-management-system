import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@models/entity-attribute.model';
import { Faculty } from '@models/faculty.model';
import { getTeacherDisplay } from '@models/teacher.model';
import { getAddressDisplay } from '@models/address.model';
import { FacultyService } from '@services/faculty.service';
import { AddressService } from '@services/address.service';
import { TeacherService } from '@services/teacher.service';

@Component({
  selector: 'app-faculty',
  templateUrl: './faculty.component.html',
  styleUrls: ['./faculty.component.scss'],
})
export class FacultyComponent extends BaseComponent<Faculty> implements OnInit {
  name: string = 'faculty';
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
      key: 'email',
      name: 'Email',
      type: 'email',
      required: true,
    },
    {
      key: 'dean',
      name: 'Dean',
      type: 'select',
      required: true,
      display: getTeacherDisplay,
    },
    {
      key: 'address',
      name: 'Address',
      type: 'select',
      required: true,
      display: getAddressDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: FacultyService,
    public teacherService: TeacherService,
    public addressService: AddressService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
    this.getOptions('dean', this.teacherService);
    this.getOptions('address', this.addressService);
  }
}
