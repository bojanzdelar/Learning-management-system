import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherServicesComponent } from './teacher-services.component';

describe('TeacherServicesComponent', () => {
  let component: TeacherServicesComponent;
  let fixture: ComponentFixture<TeacherServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeacherServicesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeacherServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
