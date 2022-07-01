import { NgModule, Optional, SkipSelf } from '@angular/core';
import { AddressService } from './services/address.service';
import { CityService } from './services/city.service';
import { CountryService } from './services/country.service';
import { FacultyService } from './services/faculty.service';
import { StudentService } from './services/student.service';
import { StudyProgramService } from './services/study-program.service';
import { SubjectMaterialService } from './services/subject-material.service';
import { SubjectService } from './services/subject.service';
import { TeacherService } from './services/teacher.service';
import { ThesisService } from './services/thesis.service';
import { UserService } from './services/user.service';

@NgModule({
  declarations: [],
  imports: [],
  providers: [
    AddressService,
    CityService,
    CountryService,
    FacultyService,
    StudentService,
    StudyProgramService,
    SubjectService,
    SubjectMaterialService,
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
