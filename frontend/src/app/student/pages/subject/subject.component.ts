import { Component, OnInit } from '@angular/core';
import { Subject } from '@core/models/subject.model';
import { AuthService } from '@core/services/auth.service';
import { SubjectService } from '@core/services/subject.service';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss'],
})
export class SubjectComponent implements OnInit {
  subjects: Subject[];

  constructor(
    public authService: AuthService,
    public service: SubjectService
  ) {}

  ngOnInit(): void {
    this.getSubjects();
  }

  getSubjects() {
    this.service
      .getByStudentId(this.authService.getStudentId())
      .subscribe((subjects: Subject[]) => {
        this.subjects = subjects;
      });
  }
}
