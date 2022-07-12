import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/directives/base-component';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { Address } from '@core/models/address.model';
import { getCityDisplay } from '@core/models/city.model';
import { AddressService } from '@core/services/address.service';
import { CityService } from '@core/services/city.service';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.scss'],
})
export class AddressComponent extends BaseComponent<Address> implements OnInit {
  title: string = 'Addresses';
  name: string = 'address';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'street',
      name: 'Street',
      type: 'text',
      required: true,
    },
    {
      key: 'number',
      name: 'Number',
      type: 'number',
      required: true,
    },
    {
      key: 'city',
      name: 'City',
      type: 'select',
      required: true,
      display: getCityDisplay,
    },
  ];

  constructor(
    public override dialog: MatDialog,
    public override service: AddressService,
    public cityService: CityService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
    this.getOptions('city', this.cityService);
  }
}
