import { Component, OnInit } from '@angular/core';
import { getTeacherDisplay } from '@core/models/teacher.model';
import { Thesis } from '@core/models/thesis.model';
import { AuthService } from '@core/services/auth.service';
import { ThesisService } from '@core/services/thesis.service';

@Component({
  selector: 'app-thesis',
  templateUrl: './thesis.component.html',
  styleUrls: ['./thesis.component.scss'],
})
export class ThesisComponent implements OnInit {
  thesis: Thesis;

  getTeacherDisplay = getTeacherDisplay;

  constructor(public authService: AuthService, public service: ThesisService) {}

  ngOnInit(): void {
    this.getThesis();
  }

  getThesis() {
    this.service.getByStudentId(this.authService.getStudentId()).subscribe({
      next: (thesis: Thesis) => {
        this.thesis = thesis;
      },
      error: () => {},
    });
  }
}
