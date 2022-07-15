import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';

import { StudentRoutingModule } from './student-routing.module';
import { StudentServicesComponent } from './pages/student-services.component';
import { SubjectComponent } from './pages/subject/subject.component';
import { SubjectEnrollmentComponent } from './pages/subject-enrollment/subject-enrollment.component';
import { ExamTermComponent } from './pages/exam-term/exam-term.component';
import { ExamRealizationComponent } from './pages/exam-realization/exam-realization.component';
import { InfoComponent } from './pages/info/info.component';
import { ThesisComponent } from './pages/thesis/thesis.component';
import { DialogRegisterComponent } from './pages/exam-term/dialog-register/dialog-register.component';

@NgModule({
  declarations: [
    StudentServicesComponent,
    SubjectComponent,
    SubjectEnrollmentComponent,
    ExamTermComponent,
    ExamRealizationComponent,
    InfoComponent,
    ThesisComponent,
    DialogRegisterComponent,
  ],
  imports: [SharedModule, StudentRoutingModule],
})
export class StudentModule {}
