import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@models/entity-attribute.model';
import { TeacherTitle } from '@models/teacher-title.model';
import { TeacherTitleService } from '@services/teacher-title.service';

@Component({
  selector: 'app-thesis',
  templateUrl: './teacher-title.component.html',
  styleUrls: ['./teacher-title.component.scss'],
})
export class TeacherTitleComponent
  extends BaseComponent<TeacherTitle>
  implements OnInit
{
  title: string = 'Teacher titles';
  name: string = 'teacher title';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'title',
      name: 'Title',
      type: 'string',
      required: true,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: TeacherTitleService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
  }
}
