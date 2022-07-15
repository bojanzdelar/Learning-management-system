import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamTermComponent } from './exam-term.component';

describe('ExamTermComponent', () => {
  let component: ExamTermComponent;
  let fixture: ComponentFixture<ExamTermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamTermComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamTermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
