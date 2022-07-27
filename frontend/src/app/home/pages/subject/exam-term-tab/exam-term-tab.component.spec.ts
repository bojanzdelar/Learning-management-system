import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamTermTabComponent } from './exam-term-tab.component';

describe('ExamTermTabComponent', () => {
  let component: ExamTermTabComponent;
  let fixture: ComponentFixture<ExamTermTabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamTermTabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamTermTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
