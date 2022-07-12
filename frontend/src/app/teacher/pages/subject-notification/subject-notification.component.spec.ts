import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectNotificationComponent } from './subject-notification.component';

describe('SubjectNotificationComponent', () => {
  let component: SubjectNotificationComponent;
  let fixture: ComponentFixture<SubjectNotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectNotificationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
