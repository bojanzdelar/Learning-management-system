import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import { getStudyProgramDisplay } from '@core/models/study-program.model';
import { Subject } from '@core/models/subject.model';
import { AuthService } from '@core/services/auth.service';
import { SubjectService } from '@core/services/subject.service';
import { DialogFormComponent } from '@shared/components/dialog-form/dialog-form.component';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss'],
})
export class SubjectComponent implements OnInit {
  attributes: EntityAttribute[] = [
    {
      key: 'syllabus',
      name: 'Syllabus',
      type: 'lob',
      required: true,
    },
  ];

  subjects: Subject[];

  getStudyProgramDisplay = getStudyProgramDisplay;

  constructor(
    public dialog: MatDialog,
    public authService: AuthService,
    public service: SubjectService
  ) {}

  ngOnInit(): void {
    this.getSubjects();
  }

  getSubjects() {
    this.service
      .getByTeacherId(this.authService.getTeacherId())
      .subscribe((subjects: Subject[]) => {
        this.subjects = subjects;
      });
  }

  editSyllabus(subject: any) {
    const dialogRef = this.dialog.open(DialogFormComponent, {
      data: {
        name: 'syllabus',
        attributes: this.attributes,
        value: subject,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.service
          .updateSyllabus(subject.id, result.syllabus)
          .subscribe(() => {
            this.getSubjects();
          });
      }
    });
  }
}
