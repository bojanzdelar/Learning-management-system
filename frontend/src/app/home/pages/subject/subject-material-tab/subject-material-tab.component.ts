import { Component, Input, OnInit } from '@angular/core';
import { SubjectMaterial } from '@core/models/subject-material.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { formatDateTime } from '@shared/utils/utility';

@Component({
  selector: 'app-subject-material-tab',
  templateUrl: './subject-material-tab.component.html',
  styleUrls: ['./subject-material-tab.component.scss'],
})
export class SubjectMaterialTabComponent implements OnInit {
  @Input()
  subjectMaterials: SubjectMaterial[];

  getTeacherDisplay = getTeacherDisplay;
  formatDateTime = formatDateTime;

  constructor() {}

  ngOnInit(): void {}
}
