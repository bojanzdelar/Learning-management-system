import { TestBed } from '@angular/core/testing';

import { SubjectMaterialService } from './subject-material.service';

describe('SubjectMaterialService', () => {
  let service: SubjectMaterialService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubjectMaterialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
