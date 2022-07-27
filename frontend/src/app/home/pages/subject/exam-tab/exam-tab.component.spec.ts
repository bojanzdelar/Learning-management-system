import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamTabComponent } from './exam-tab.component';

describe('ExamTabComponent', () => {
  let component: ExamTabComponent;
  let fixture: ComponentFixture<ExamTabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamTabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
