import { Component, Input, OnInit } from '@angular/core';
import { SubjectNotification } from '@core/models/subject-notification.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { formatDateTime } from '@shared/utils/utility';

@Component({
  selector: 'app-subject-notification-tab',
  templateUrl: './subject-notification-tab.component.html',
  styleUrls: ['./subject-notification-tab.component.scss'],
})
export class SubjectNotificationTabComponent implements OnInit {
  @Input()
  subjectNotifications: SubjectNotification[];

  getTeacherDisplay = getTeacherDisplay;
  formatDateTime = formatDateTime;

  constructor() {}

  ngOnInit(): void {}
}
