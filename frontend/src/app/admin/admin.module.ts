import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { AdminRoutingModule } from './admin-routing.module';

import { AdminComponent } from './pages/admin/admin.component';
import { AddressComponent } from './components/address/address.component';
import { CityComponent } from './components/city/city.component';
import { CountryComponent } from './components/country/country.component';
import { FacultyComponent } from './components/faculty/faculty.component';
import { StudentComponent } from './components/student/student.component';
import { StudyProgramComponent } from './components/study-program/study-program.component';
import { TeacherComponent } from './components/teacher/teacher.component';
import { ThesisComponent } from './components/thesis/thesis.component';
import { UserComponent } from './components/user/user.component';
import { SubjectComponent } from './components/subject/subject.component';

@NgModule({
  declarations: [
    AdminComponent,
    AddressComponent,
    CityComponent,
    CountryComponent,
    FacultyComponent,
    StudentComponent,
    StudyProgramComponent,
    TeacherComponent,
    ThesisComponent,
    UserComponent,
    SubjectComponent,
  ],
  imports: [SharedModule, AdminRoutingModule],
})
export class AdminModule {}
