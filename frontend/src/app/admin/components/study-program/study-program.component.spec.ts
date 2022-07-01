import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudyProgramComponent } from './study-program.component';

describe('StudyProgramComponent', () => {
  let component: StudyProgramComponent;
  let fixture: ComponentFixture<StudyProgramComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudyProgramComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudyProgramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
