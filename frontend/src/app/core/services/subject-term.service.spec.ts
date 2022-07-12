import { TestBed } from '@angular/core/testing';

import { SubjectTermService } from './subject-term.service';

describe('SubjectTermService', () => {
  let service: SubjectTermService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubjectTermService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
