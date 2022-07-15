import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamRealizationComponent } from './exam-realization.component';

describe('ExamRealizationComponent', () => {
  let component: ExamRealizationComponent;
  let fixture: ComponentFixture<ExamRealizationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamRealizationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamRealizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
