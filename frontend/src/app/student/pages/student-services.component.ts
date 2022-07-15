import { Component, OnInit } from '@angular/core';
import { SidenavItem } from '@core/models/sidenav-item.model';

@Component({
  selector: 'app-student-services',
  templateUrl: './student-services.component.html',
  styleUrls: ['./student-services.component.scss'],
})
export class StudentServicesComponent implements OnInit {
  items: (SidenavItem | '-')[] = [
    {
      text: 'My subjects',
      link: '/student-services/my-subjects',
    },
    {
      text: 'Subject enrollments',
      link: '/student-services/subject-enrollments',
    },
    '-',
    {
      text: 'Exam terms registration',
      link: '/student-services/exam-terms-registration',
    },
    {
      text: 'Exam realizations',
      link: '/student-services/exam-realizations',
    },
    '-',
    {
      text: 'My info',
      link: '/student-services/my-info',
    },
    {
      text: 'My thesis',
      link: '/student-services/my-thesis',
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
