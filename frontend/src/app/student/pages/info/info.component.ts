import { Component, OnInit } from '@angular/core';
import { Student } from '@core/models/student.model';
import { getStudyProgramDisplay } from '@core/models/study-program.model';
import { getUserDisplay } from '@core/models/user.model';
import { AuthService } from '@core/services/auth.service';
import { StudentService } from '@core/services/student.service';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.scss'],
})
export class InfoComponent implements OnInit {
  student: Student;

  getUserDisplay = getUserDisplay;
  getStudyProgramDisplay = getStudyProgramDisplay;

  constructor(
    public authService: AuthService,
    public studentService: StudentService
  ) {}

  ngOnInit(): void {
    this.getStudent();
  }

  getStudent() {
    this.studentService
      .getById([this.authService.getStudentId()])
      .subscribe((student: Student[]) => {
        this.student = student[0];
      });
  }
}
