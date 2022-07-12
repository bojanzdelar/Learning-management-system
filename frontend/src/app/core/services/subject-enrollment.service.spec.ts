import { TestBed } from '@angular/core/testing';

import { SubjectEnrollmentService } from './subject-enrollment.service';

describe('SubjectEnrollmentService', () => {
  let service: SubjectEnrollmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubjectEnrollmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
