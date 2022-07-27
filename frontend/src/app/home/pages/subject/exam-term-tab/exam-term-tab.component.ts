import { Component, Input, OnInit } from '@angular/core';
import { getExamPeriodDisplay } from '@core/models/exam-period.model';
import { ExamTerm } from '@core/models/exam-term.model';
import { formatDateTime } from '@shared/utils/utility';

@Component({
  selector: 'app-exam-term-tab',
  templateUrl: './exam-term-tab.component.html',
  styleUrls: ['./exam-term-tab.component.scss'],
})
export class ExamTermTabComponent implements OnInit {
  @Input()
  examTerms: ExamTerm[];

  getExamPeriodDisplay = getExamPeriodDisplay;
  formatDateTime = formatDateTime;

  constructor() {}

  ngOnInit(): void {}
}
