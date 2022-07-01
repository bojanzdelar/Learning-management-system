import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { getFacultyDisplay } from '@core/models/faculty.model';
import { StudyProgram } from '@core/models/study-program.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { StudyProgramService } from '@core/services/study-program.service';
import { Subject } from '@core/models/subject.model';
import { SubjectService } from '@core/services/subject.service';

@Component({
  selector: 'app-study-program',
  templateUrl: './study-program.component.html',
  styleUrls: ['./study-program.component.scss'],
})
export class StudyProgramComponent implements OnInit {
  studyProgram: StudyProgram;
  subjects: Subject[];

  getFacultyDisplay = getFacultyDisplay;
  getTeacherDisplay = getTeacherDisplay;

  constructor(
    public studyProgramService: StudyProgramService,
    public subjectService: SubjectService,
    public route: ActivatedRoute,
    public router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.studyProgramService.getById([id]).subscribe({
      next: (studyProgram: StudyProgram[]) => {
        this.studyProgram = studyProgram[0];
      },
      error: () => {
        this.router.navigate(['/']);
      },
    });

    this.subjectService.getByStudyProgramId(id).subscribe({
      next: (subjects: Subject[]) => {
        this.subjects = subjects;
      },
      error: () => {},
    });
  }

  viewSubject(subject: Subject) {
    this.router.navigate(['/subjects', subject.id]);
  }
}
