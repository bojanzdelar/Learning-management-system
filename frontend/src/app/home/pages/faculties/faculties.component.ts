import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Faculty } from '@core/models/faculty.model';
import { FacultyService } from '@core/services/faculty.service';

@Component({
  selector: 'app-faculties',
  templateUrl: './faculties.component.html',
  styleUrls: ['./faculties.component.scss'],
})
export class FacultiesComponent implements OnInit {
  faculties: Faculty[];

  constructor(public facultyService: FacultyService, public router: Router) {}

  ngOnInit(): void {
    this.facultyService.getAll().subscribe((data) => {
      this.faculties = data;
    });
  }

  viewFaculty(faculty: Faculty) {
    const id = faculty.id;
    if (!id) return;

    this.router.navigate(['/faculties', id]);
  }
}
