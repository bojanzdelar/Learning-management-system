import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Faculty } from '@core/models/faculty.model';
import { StudyProgram } from '@core/models/study-program.model';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { getAddressDisplay } from '@core/models/address.model';
import { FacultyService } from '@core/services/faculty.service';
import { StudyProgramService } from '@core/services/study-program.service';

@Component({
  selector: 'app-faculty',
  templateUrl: './faculty.component.html',
  styleUrls: ['./faculty.component.scss'],
})
export class FacultyComponent implements OnInit {
  faculty: Faculty;
  studyPrograms: StudyProgram[];

  getTeacherDisplay = getTeacherDisplay;
  getAddressDisplay = getAddressDisplay;

  constructor(
    public facultyService: FacultyService,
    public studyProgramService: StudyProgramService,
    public route: ActivatedRoute,
    public router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.facultyService.getById([id]).subscribe({
      next: (faculty: Faculty[]) => {
        this.faculty = faculty[0];
      },
      error: () => {
        this.router.navigate(['/faculties']);
      },
    });

    this.studyProgramService.getByFacultyId(id).subscribe({
      next: (studyPrograms: StudyProgram[]) => {
        this.studyPrograms = studyPrograms;
      },
      error: () => {},
    });
  }

  viewStudyProgram(studyProgram: StudyProgram) {
    this.router.navigate(['/study-programs', studyProgram.id]);
  }
}
