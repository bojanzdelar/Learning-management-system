import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamPeriodComponent } from './exam-period.component';

describe('ExamPeriodComponent', () => {
  let component: ExamPeriodComponent;
  let fixture: ComponentFixture<ExamPeriodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamPeriodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamPeriodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
