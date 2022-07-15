import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { AdminRoutingModule } from './admin-routing.module';

import { AdminPanelComponent } from './pages/admin-panel.component';
import { AdministratorComponent } from './pages/administrator/administrator.component';
import { AddressComponent } from './pages/address/address.component';
import { CityComponent } from './pages/city/city.component';
import { CountryComponent } from './pages/country/country.component';
import { ExamPeriodComponent } from './pages/exam-period/exam-period.component';
import { ExamTermComponent } from './pages/exam-term/exam-term.component';
import { ExamTypeComponent } from './pages/exam-type/exam-type.component';
import { FacultyComponent } from './pages/faculty/faculty.component';
import { StudentComponent } from './pages/student/student.component';
import { StudyProgramComponent } from './pages/study-program/study-program.component';
import { TeacherComponent } from './pages/teacher/teacher.component';
import { ThesisComponent } from './pages/thesis/thesis.component';
import { SubjectComponent } from './pages/subject/subject.component';

@NgModule({
  declarations: [
    AdminPanelComponent,
    AdministratorComponent,
    AddressComponent,
    CityComponent,
    CountryComponent,
    ExamPeriodComponent,
    ExamTermComponent,
    ExamTypeComponent,
    FacultyComponent,
    StudentComponent,
    StudyProgramComponent,
    TeacherComponent,
    ThesisComponent,
    SubjectComponent,
  ],
  imports: [SharedModule, AdminRoutingModule],
})
export class AdminModule {}
