import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from '@core/models/subject.model';
import { SubjectMaterial } from '@core/models/subject-material.model';
import { SubjectNotification } from '@core/models/subject-notification.model';
import { SubjectTerm } from '@core/models/subject-term.model';
import { Exam, getExamDisplay } from '@core/models/exam.model';
import { ExamTerm } from '@core/models/exam-term.model';
import { getStudyProgramDisplay } from '@core/models/study-program.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { getExamTypeDisplay } from '@core/models/exam-type.model';
import { SubjectService } from '@core/services/subject.service';
import { SubjectMaterialService } from '@core/services/subject-material.service';
import { SubjectNotificationService } from '@core/services/subject-notification.service';
import { SubjectTermService } from '@core/services/subject-term.service';
import { ExamService } from '@core/services/exam.service';
import { ExamTermService } from '@core/services/exam-term.service';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss'],
})
export class SubjectComponent implements OnInit {
  subject: Subject;
  subjectMaterials: SubjectMaterial[];
  subjectNotifications: SubjectNotification[];
  subjectTerms: SubjectTerm[];
  exams: Exam[];
  examTerms: ExamTerm[];

  getStudyProgramDisplay = getStudyProgramDisplay;
  getTeacherDisplay = getTeacherDisplay;

  constructor(
    public subjectService: SubjectService,
    public subjectMaterialService: SubjectMaterialService,
    public subjectNotificationService: SubjectNotificationService,
    public subjectTermService: SubjectTermService,
    public examService: ExamService,
    public examTermService: ExamTermService,
    private route: ActivatedRoute,
    private router: Router
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

    this.subjectMaterialService.getBySubjectIdAll(id).subscribe({
      next: (subjectMaterials: SubjectMaterial[]) => {
        this.subjectMaterials = subjectMaterials;
      },
      error: () => {},
    });

    this.subjectNotificationService.getBySubjectIdAll(id).subscribe({
      next: (subjectNotifications: SubjectNotification[]) => {
        this.subjectNotifications = subjectNotifications;
      },
      error: () => {},
    });

    this.subjectTermService.getBySubjectIdAll(id).subscribe({
      next: (subjectTerms: SubjectTerm[]) => {
        this.subjectTerms = subjectTerms;
      },
      error: () => {},
    });

    this.examService.getBySubjectIdAll(id).subscribe({
      next: (exams: Exam[]) => {
        this.exams = exams;
      },
      error: () => {},
    });

    this.examTermService.getBySubjectIdAll(id).subscribe({
      next: (examTerms: ExamTerm[]) => {
        this.examTerms = examTerms;
      },
      error: () => {},
    });
  }
}
