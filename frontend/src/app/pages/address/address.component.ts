import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BaseComponent } from '@shared/base-component';
import { EntityAttribute } from '@models/entity-attribute.model';
import { Address } from '@models/address.model';
import { getCityDisplay } from '@models/city.model';
import { AddressService } from '@services/address.service';
import { CityService } from '@services/city.service';

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
    this.getPage(this.pageRequest);
    this.getOptions('city', this.cityService);
  }
}