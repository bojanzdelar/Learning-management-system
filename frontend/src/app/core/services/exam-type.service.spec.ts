import { TestBed } from '@angular/core/testing';

import { ExamTypeService } from './exam-type.service';

describe('ExamTypeService', () => {
  let service: ExamTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
