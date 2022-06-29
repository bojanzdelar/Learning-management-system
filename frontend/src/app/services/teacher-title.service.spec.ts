import { TestBed } from '@angular/core/testing';

import { TeacherTitleService } from './teacher-title.service';

describe('TeacherTitleService', () => {
  let service: TeacherTitleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TeacherTitleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
