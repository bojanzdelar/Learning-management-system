import { TestBed } from '@angular/core/testing';

import { ResponseInterceptor } from './response.interceptor';

describe('ResponseInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      ResponseInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: ResponseInterceptor = TestBed.inject(ResponseInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
