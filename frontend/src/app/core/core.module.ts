import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule, Optional, SkipSelf } from '@angular/core';
import { RequestInterceptor } from './interceptors/request.interceptor';
import { ResponseInterceptor } from './interceptors/response.interceptor';

import { AddressService } from './services/address.service';
import { AdministratorService } from './services/administrator.service';
import { CityService } from './services/city.service';
import { CountryService } from './services/country.service';
import { ExamService } from './services/exam.service';
import { ExamPeriodService } from './services/exam-period.service';
import { ExamRealizationService } from './services/exam-realization.service';
import { ExamTermService } from './services/exam-term.service';
import { ExamTypeService } from './services/exam-type.service';
import { FacultyService } from './services/faculty.service';
import { StudentService } from './services/student.service';
import { StudyProgramService } from './services/study-program.service';
import { SubjectService } from './services/subject.service';
import { SubjectEnrollmentService } from './services/subject-enrollment.service';
import { SubjectMaterialService } from './services/subject-material.service';
import { SubjectNotificationService } from './services/subject-notification.service';
import { SubjectTermService } from './services/subject-term.service';
import { TeacherService } from './services/teacher.service';
import { ThesisService } from './services/thesis.service';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [],
  imports: [],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: RequestInterceptor,
      multi: true,
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ResponseInterceptor,
      multi: true,
    },
    AddressService,
    AdministratorService,
    CityService,
    CountryService,
    FacultyService,
    ExamService,
    ExamPeriodService,
    ExamRealizationService,
    ExamTermService,
    ExamTypeService,
    StudentService,
    StudyProgramService,
    SubjectService,
    SubjectEnrollmentService,
    SubjectMaterialService,
    SubjectNotificationService,
    SubjectTermService,
    TeacherService,
    ThesisService,
    UserService,
  ],
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() core: CoreModule) {
    if (core) {
      throw new Error(
        'CoreModule is already loaded. Import it in the AppModule only'
      );
    }
  }
}
