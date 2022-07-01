import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdminComponent } from './pages/admin/admin.component';
import { AddressComponent } from './components/address/address.component';
import { CityComponent } from './components/city/city.component';
import { CountryComponent } from './components/country/country.component';
import { FacultyComponent } from './components/faculty/faculty.component';
import { StudentComponent } from './components/student/student.component';
import { StudyProgramComponent } from './components/study-program/study-program.component';
import { SubjectComponent } from './components/subject/subject.component';
import { TeacherComponent } from './components/teacher/teacher.component';
import { ThesisComponent } from './components/thesis/thesis.component';
import { UserComponent } from './components/user/user.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
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
        path: 'users',
        component: UserComponent,
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
