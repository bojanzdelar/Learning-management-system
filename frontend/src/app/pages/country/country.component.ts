import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@models/entity-attribute.model';
import { City } from '@models/city.model';
import { CityService } from '@services/city.service';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.scss'],
})
export class CountryComponent extends BaseComponent<City> implements OnInit {
  title: string = 'Countries';
  name: string = 'country';
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
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: CityService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.pageRequest);
  }
}
