import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectMaterialTabComponent } from './subject-material-tab.component';

describe('SubjectMaterialTabComponent', () => {
  let component: SubjectMaterialTabComponent;
  let fixture: ComponentFixture<SubjectMaterialTabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectMaterialTabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectMaterialTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
