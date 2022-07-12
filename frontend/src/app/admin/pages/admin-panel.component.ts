import { Component, OnInit } from '@angular/core';
import { SidenavItem } from '@core/models/sidenav-item.model';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss'],
})
export class AdminPanelComponent implements OnInit {
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
    {
      text: 'Theses',
      link: '/admin-panel/theses',
    },
    '-',
    {
      text: 'Students',
      link: '/admin-panel/students',
    },
    {
      text: 'Teachers',
      link: '/admin-panel/teachers',
    },
    {
      text: 'Administrators',
      link: '/admin-panel/administrators',
    },
    '-',
    {
      text: 'Exam periods',
      link: '/admin-panel/exam-periods',
    },
    {
      text: 'Exam terms',
      link: '/admin-panel/exam-terms',
    },
    {
      text: 'Exam types',
      link: '/admin-panel/exam-types',
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

  constructor() {}

  ngOnInit(): void {}
}
