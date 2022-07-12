import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

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
import { SubjectComponent } from './pages/subject/subject.component';
import { TeacherComponent } from './pages/teacher/teacher.component';
import { ThesisComponent } from './pages/thesis/thesis.component';

const routes: Routes = [
  {
    path: '',
    component: AdminPanelComponent,
    children: [
      {
        path: '',
        redirectTo: '/admin-panel/faculties',
        pathMatch: 'full',
      },
      {
        path: 'faculties',
        component: FacultyComponent,
      },
      {
        path: 'study-programs',
        component: StudyProgramComponent,
      },
      {
        path: 'subjects',
        component: SubjectComponent,
      },
      {
        path: 'students',
        component: StudentComponent,
      },
      {
        path: 'theses',
        component: ThesisComponent,
      },
      {
        path: 'teachers',
        component: TeacherComponent,
      },
      {
        path: 'administrators',
        component: AdministratorComponent,
      },
      {
        path: 'exam-periods',
        component: ExamPeriodComponent,
      },
      {
        path: 'exam-terms',
        component: ExamTermComponent,
      },
      {
        path: 'exam-types',
        component: ExamTypeComponent,
      },
      {
        path: 'countries',
        component: CountryComponent,
      },
      {
        path: 'cities',
        component: CityComponent,
      },
      {
        path: 'addresses',
        component: AddressComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
