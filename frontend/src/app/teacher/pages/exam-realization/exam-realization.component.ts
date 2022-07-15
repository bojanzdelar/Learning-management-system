import { AfterViewInit, Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EntityAttribute } from '@core/models/entity-attribute.model';
import {
  ExamRealization,
  getStatusDisplay,
} from '@core/models/exam-realization.model';
import { getSubjectEnrollmentStudentDisplay } from '@core/models/subject-enrollment.model';
import { ExamTerm, getExamTermDisplay } from '@core/models/exam-term.model';
import { ExamRealizationService } from '@core/services/exam-realization.service';
import { ExamTermService } from '@core/services/exam-term.service';
import { AuthService } from '@core/services/auth.service';
import { BaseComponent } from '@shared/directives/base-component';
import { TableSelect } from '@core/models/table-select.model';
import { TableData } from '@core/models/table-data.model';
import { saveAs } from 'file-saver';
import { DialogImportComponent } from '@shared/components/dialog-import/dialog-import.component';
import { Validators } from '@angular/forms';
import { DialogUploadComponent } from '@shared/components/dialog-upload/dialog-upload.component';

@Component({
  selector: 'app-exam-realizations',
  templateUrl: './exam-realization.component.html',
  styleUrls: ['./exam-realization.component.scss'],
})
export class ExamRealizationComponent
  extends BaseComponent<ExamRealization>
  implements OnInit, AfterViewInit
{
  title: string = 'Exam realizations';
  name: string = 'exam realization';
  attributes: EntityAttribute[] = [
    {
      key: 'id',
      name: 'ID',
      type: 'id',
    },
    {
      key: 'subjectEnrollment',
      name: 'Student',
      type: 'skip',
      display: getSubjectEnrollmentStudentDisplay,
    },
    {
      key: 'score',
      name: 'Score',
      type: 'number',
      required: true,
      validators: [Validators.min(0), Validators.max(90)],
      errorMessage: `Score must be between 0 and 90`,
    },
    {
      key: 'passed',
      name: 'Status',
      type: 'skip',
      display: getStatusDisplay,
    },
  ];

  editable: boolean = false;

  tableSelect: TableSelect = {
    observable: this.examTermService.getByTeacherIdAll(
      this.authService.getTeacherId()
    ),
    display: getExamTermDisplay,
  };

  constructor(
    public override dialog: MatDialog,
    public override service: ExamRealizationService,
    public examTermService: ExamTermService,
    public authService: AuthService
  ) {
    super();
  }

  ngOnInit(): void {
    this.getPage(this.tableData);
  }

  ngAfterViewInit() {
    this.setEditable();
  }

  override getPage(data?: TableData) {
    data !== undefined ? (this.tableData = data) : (data = this.tableData);
    if (!data?.select) return;

    this.service
      .getByExamTermId(data.select, data?.request)
      .subscribe((data) => {
        this.data = data;
      });
  }

  setEditable() {
    const selectForm = this.table.selectForm;

    selectForm.valueChanges.subscribe((data: ExamTerm) => {
      if (!selectForm.valid) {
        return;
      }

      const examTermEnd = new Date(data.endTime);
      const scoreEntryEnd = new Date(examTermEnd);
      scoreEntryEnd.setDate(examTermEnd.getDate() + 30);
      const currentDate = new Date();

      this.editable =
        currentDate <= scoreEntryEnd && currentDate >= examTermEnd;
    });
  }

  override process(value: ExamRealization): void {
    if (!value.id) return;
    delete value['ids'];

    this.service.updateScore(value.id, value).subscribe(() => {
      this.getPage();
    });
  }

  import() {
    const dialogRef = this.dialog.open(DialogImportComponent, {
      data: `${this.name}s`,
    });

    dialogRef.afterClosed().subscribe((data) => {
      if (!data || !this.tableData.select) {
        return;
      }

      this.service
        .updateScoreByExamTermId(this.tableData.select, data)
        .subscribe({
          next: () => {
            this.getPage();
          },
          error: () => {
            window.alert(
              'Error occurred while importing data. Please try again.'
            );
          },
        });
    });
  }

  upload() {
    const dialogRef = this.dialog.open(DialogUploadComponent, {
      data: `${this.name}s`,
    });

    dialogRef.afterClosed().subscribe((data) => {
      if (!data || !this.tableData.select) {
        return;
      }

      this.service
        .updateScoreByExamTermId(this.tableData.select, data)
        .subscribe({
          next: () => {
            this.getPage();
          },
          error: () => {
            window.alert(
              'Error occurred while uploading data. Please try again.'
            );
          },
        });
    });
  }

  exportPdf() {
    if (!this.tableData?.select) return;

    this.service
      .getByExamTermIdAllPdf(this.tableData.select)
      .subscribe((data) => {
        saveAs(data, 'exam-realizations.pdf');
      });
  }
}
