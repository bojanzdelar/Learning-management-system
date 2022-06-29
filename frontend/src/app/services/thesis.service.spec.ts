import { TestBed } from '@angular/core/testing';

import { ThesisService } from './thesis.service';

describe('ThesisService', () => {
  let service: ThesisService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ThesisService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
