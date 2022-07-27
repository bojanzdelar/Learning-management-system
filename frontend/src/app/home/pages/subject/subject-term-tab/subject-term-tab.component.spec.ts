import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectTermTabComponent } from './subject-term-tab.component';

describe('SubjectTermTabComponent', () => {
  let component: SubjectTermTabComponent;
  let fixture: ComponentFixture<SubjectTermTabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectTermTabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectTermTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
