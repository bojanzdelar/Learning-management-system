import { TestBed } from '@angular/core/testing';

import { ExamRealizationService } from './exam-realization.service';

describe('ExamRealizationService', () => {
  let service: ExamRealizationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamRealizationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
