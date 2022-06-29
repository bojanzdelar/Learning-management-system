import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FacultyComponent } from '@pages/faculty/faculty.component';
import { StudyProgramComponent } from '@pages/study-program/study-program.component';
import { UserComponent } from '@pages/user/user.component';
import { StudentComponent } from '@pages/student/student.component';
import { ThesisComponent } from '@pages/thesis/thesis.component';
import { TeacherComponent } from '@pages/teacher/teacher.component';
import { TeacherTitleComponent } from '@pages/teacher-title/teacher-title.component';
import { CountryComponent } from '@pages/country/country.component';
import { CityComponent } from '@pages/city/city.component';
import { AddressComponent } from '@pages/address/address.component';

import { NotFoundComponent } from '@components/not-found/not-found.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/faculties',
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
    path: 'teacher-titles',
    component: TeacherTitleComponent,
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
  {
    path: '**',
    component: NotFoundComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
