import { Component, Input, OnInit } from '@angular/core';
import { getExamTypeDisplay } from '@core/models/exam-type.model';
import { Exam } from '@core/models/exam.model';

@Component({
  selector: 'app-exam-tab',
  templateUrl: './exam-tab.component.html',
  styleUrls: ['./exam-tab.component.scss'],
})
export class ExamTabComponent implements OnInit {
  @Input()
  exams: Exam[];

  getExamTypeDisplay = getExamTypeDisplay;

  constructor() {}

  ngOnInit(): void {}
}
