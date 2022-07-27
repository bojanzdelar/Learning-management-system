import { Component, Input, OnInit } from '@angular/core';
import { SubjectTerm } from '@core/models/subject-term.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { formatDateTime } from '@shared/utils/utility';

@Component({
  selector: 'app-subject-term-tab',
  templateUrl: './subject-term-tab.component.html',
  styleUrls: ['./subject-term-tab.component.scss'],
})
export class SubjectTermTabComponent implements OnInit {
  @Input()
  subjectTerms: SubjectTerm[];

  getTeacherDisplay = getTeacherDisplay;
  formatDateTime = formatDateTime;

  constructor() {}

  ngOnInit(): void {}
}
