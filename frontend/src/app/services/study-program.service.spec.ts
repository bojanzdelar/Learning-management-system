import { TestBed } from '@angular/core/testing';

import { StudyProgramService } from './study-program.service';

describe('StudyProgramService', () => {
  let service: StudyProgramService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudyProgramService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
