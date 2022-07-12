import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { City } from '@core/models/city.model';
import { getCountryDisplay } from '@core/models/country.model';
import { CityService } from '@core/services/city.service';
import { CountryService } from '@core/services/country.service';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.scss'],
})
export class CityComponent extends BaseComponent<City> implements OnInit {
  title: string = 'Cities';
  name: string = 'city';
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
      key: 'country',
      name: 'Country',
      type: 'select',
      required: true,
      display: getCountryDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: CityService,
    public countryService: CountryService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
    this.getOptions('country', this.countryService);
  }
}
