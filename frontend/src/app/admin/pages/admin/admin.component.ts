import { Component, OnInit } from '@angular/core';
import { SidenavItem } from '@core/models/sidenav-item.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss'],
})
export class AdminComponent implements OnInit {
  items: (SidenavItem | '-')[] = [
    {
      text: 'Faculties',
      link: '/admin-panel/faculties',
    },
    {
      text: 'Study programs',
      link: '/admin-panel/study-programs',
    },
    {
      text: 'Subjects',
      link: '/admin-panel/subjects',
    },
    '-',
    {
      text: 'Users',
      link: '/admin-panel/users',
    },
    {
      text: 'Students',
      link: '/admin-panel/students',
    },
    {
      text: 'Theses',
      link: '/admin-panel/theses',
    },
    {
      text: 'Teachers',
      link: '/admin-panel/teachers',
    },
    '-',
    {
      text: 'Countries',
      link: '/admin-panel/countries',
    },
    {
      text: 'Cities',
      link: '/admin-panel/cities',
    },
    {
      text: 'Addresses',
      link: '/admin-panel/addresses',
    },
  ];

  //     <a mat-list-item routerLink="/admin-panel/faculties">Faculties</a>
  //   <a mat-list-item routerLink="/admin-panel/study-programs">
  //     Study programs
  //   </a>
  //   <a mat-list-item routerLink="/admin-panel/subjects">Subjects</a>
  //   <mat-divider></mat-divider>
  //   <a mat-list-item routerLink="/admin-panel/users">Users</a>
  //   <a mat-list-item routerLink="/admin-panel/students">Students</a>
  //   <a mat-list-item routerLink="/admin-panel/theses">Theses</a>
  //   <a mat-list-item routerLink="/admin-panel/teachers">Teachers</a>
  //   <mat-divider></mat-divider>
  //   <a mat-list-item routerLink="/admin-panel/countries">Countries</a>
  //   <a mat-list-item routerLink="/admin-panel/cities">Cities</a>
  //   <a mat-list-item routerLink="/admin-panel/addresses">Addresses</a>
  // </mat-nav-list>

  constructor() {}

  ngOnInit(): void {}
}
