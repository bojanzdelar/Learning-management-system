import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectNotificationTabComponent } from './subject-notification-tab.component';

describe('SubjectNotificationTabComponent', () => {
  let component: SubjectNotificationTabComponent;
  let fixture: ComponentFixture<SubjectNotificationTabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubjectNotificationTabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubjectNotificationTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
