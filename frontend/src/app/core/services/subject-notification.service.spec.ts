import { TestBed } from '@angular/core/testing';

import { SubjectNotificationService } from './subject-notification.service';

describe('SubjectNotificationService', () => {
  let service: SubjectNotificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubjectNotificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
