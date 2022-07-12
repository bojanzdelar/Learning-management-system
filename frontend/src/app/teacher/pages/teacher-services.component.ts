import { Component, OnInit } from '@angular/core';
import { SidenavItem } from '@core/models/sidenav-item.model';

@Component({
  selector: 'app-teacher-services',
  templateUrl: './teacher-services.component.html',
  styleUrls: ['./teacher-services.component.scss'],
})
export class TeacherServicesComponent implements OnInit {
  items: (SidenavItem | '-')[] = [
    {
      text: 'My subjects',
      link: '/teacher-services/my-subjects',
    },
    {
      text: 'Subject materials',
      link: '/teacher-services/subject-materials',
    },
    {
      text: 'Subject notifications',
      link: '/teacher-services/subject-notifications',
    },
    {
      text: 'Subject terms',
      link: '/teacher-services/subject-terms',
    },
    {
      text: 'Subject enrollments',
      link: '/teacher-services/subject-enrollments',
    },
    '-',
    {
      text: 'Exams',
      link: '/teacher-services/exams',
    },
    {
      text: 'Exam realizations',
      link: '/teacher-services/exam-realizations',
    },
    '-',
    {
      text: 'Students',
      link: '/teacher-services/students',
    },
    {
      text: 'Theses',
      link: '/teacher-services/theses',
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
