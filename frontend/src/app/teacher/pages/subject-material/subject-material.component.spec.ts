import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectMaterialComponent } from './subject-material.component';

describe('SubjectMaterialComponent', () => {
  let component: SubjectMaterialComponent;
  let fixture: ComponentFixture<SubjectMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectMaterialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
