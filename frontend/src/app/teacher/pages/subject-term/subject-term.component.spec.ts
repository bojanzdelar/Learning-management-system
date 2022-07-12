import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectTermComponent } from './subject-term.component';

describe('SubjectTermComponent', () => {
  let component: SubjectTermComponent;
  let fixture: ComponentFixture<SubjectTermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectTermComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectTermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
