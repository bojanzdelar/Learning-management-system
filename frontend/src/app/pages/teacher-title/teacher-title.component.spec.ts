import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherTitleComponent } from './teacher-title.component';

describe('TeacherTitleComponent', () => {
  let component: TeacherTitleComponent;
  let fixture: ComponentFixture<TeacherTitleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeacherTitleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeacherTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
