import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableComponent } from '@components/table/table.component';
import { DialogFormComponent } from '@components/dialog-form/dialog-form.component';
import { DialogDeleteComponent } from '@components/dialog-delete/dialog-delete.component';
import { NotFoundComponent } from '@components/not-found/not-found.component';

import { FacultyComponent } from '@pages/faculty/faculty.component';
import { StudyProgramComponent } from './pages/study-program/study-program.component';
import { AddressComponent } from './pages/address/address.component';
import { CityComponent } from './pages/city/city.component';
import { CountryComponent } from './pages/country/country.component';
import { StudentComponent } from './pages/student/student.component';
import { TeacherComponent } from './pages/teacher/teacher.component';
import { TeacherTitleComponent } from './pages/teacher-title/teacher-title.component';
import { UserComponent } from './pages/user/user.component';
import { ThesisComponent } from './pages/thesis/thesis.component';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    DialogFormComponent,
    DialogDeleteComponent,
    NotFoundComponent,
    FacultyComponent,
    StudyProgramComponent,
    AddressComponent,
    CityComponent,
    CountryComponent,
    StudentComponent,
    TeacherComponent,
    TeacherTitleComponent,
    UserComponent,
    ThesisComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatIconModule,
    MatDialogModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
