import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { HomeRoutingModule } from './home-routing.module';

import { HomeComponent } from './pages/home/home.component';
import { FacultiesComponent } from './pages/faculties/faculties.component';
import { FacultyComponent } from './pages/faculty/faculty.component';
import { StudyProgramComponent } from './pages/study-program/study-program.component';
import { SubjectComponent } from './pages/subject/subject.component';
import { AboutComponent } from './pages/about/about.component';

@NgModule({
  declarations: [
    HomeComponent,
    FacultiesComponent,
    FacultyComponent,
    StudyProgramComponent,
    SubjectComponent,
    AboutComponent,
  ],
  imports: [SharedModule, HomeRoutingModule],
})
export class HomeModule {}
