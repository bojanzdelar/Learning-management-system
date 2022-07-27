import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { HomeRoutingModule } from './home-routing.module';

import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { FacultiesComponent } from './pages/faculties/faculties.component';
import { FacultyComponent } from './pages/faculty/faculty.component';
import { StudyProgramComponent } from './pages/study-program/study-program.component';
import { SubjectComponent } from './pages/subject/subject.component';
import { SubjectMaterialTabComponent } from './pages/subject/subject-material-tab/subject-material-tab.component';
import { SubjectNotificationTabComponent } from './pages/subject/subject-notification-tab/subject-notification-tab.component';
import { SubjectTermTabComponent } from './pages/subject/subject-term-tab/subject-term-tab.component';
import { ExamTabComponent } from './pages/subject/exam-tab/exam-tab.component';
import { ExamTermTabComponent } from './pages/subject/exam-term-tab/exam-term-tab.component';

@NgModule({
  declarations: [
    HomeComponent,
    AboutComponent,
    FacultiesComponent,
    FacultyComponent,
    StudyProgramComponent,
    SubjectComponent,
    SubjectMaterialTabComponent,
    SubjectNotificationTabComponent,
    SubjectTermTabComponent,
    ExamTabComponent,
    ExamTermTabComponent,
  ],
  imports: [SharedModule, HomeRoutingModule],
})
export class HomeModule {}
