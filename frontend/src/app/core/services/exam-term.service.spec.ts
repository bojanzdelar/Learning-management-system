import { TestBed } from '@angular/core/testing';

import { ExamTermService } from './exam-term.service';

describe('ExamTermService', () => {
  let service: ExamTermService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamTermService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
