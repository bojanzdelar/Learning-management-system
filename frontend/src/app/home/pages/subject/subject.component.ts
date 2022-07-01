import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from '@core/models/subject.model';
import { SubjectService } from '@core/services/subject.service';
import { SubjectMaterial } from '@core/models/subject-material.model';
import { SubjectMaterialService } from '@core/services/subject-material.service';
import { getStudyProgramDisplay } from '@core/models/study-program.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { formatDateTime } from '@shared/utility';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss'],
})
export class SubjectComponent implements OnInit {
  subject: Subject;
  subjectMaterials: SubjectMaterial[];

  getStudyProgramDisplay = getStudyProgramDisplay;
  getTeacherDisplay = getTeacherDisplay;
  formatDateTime = formatDateTime;

  constructor(
    public subjectService: SubjectService,
    public subjectMaterialService: SubjectMaterialService,
    public route: ActivatedRoute,
    public router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.subjectService.getById([id]).subscribe({
      next: (subject: Subject[]) => {
        this.subject = subject[0];
      },
      error: () => {
        this.router.navigate(['/']);
      },
    });

    this.subjectMaterialService.getBySubjectId(id).subscribe({
      next: (subjectMaterials: SubjectMaterial[]) => {
        this.subjectMaterials = subjectMaterials;
      },
      error: () => {},
    });
  }
}
