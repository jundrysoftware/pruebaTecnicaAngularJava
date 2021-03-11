import { TestBed } from '@angular/core/testing';

import { MethodApiRestServiceService } from './method-api-rest-service.service';

describe('MethodApiRestServiceService', () => {
  let service: MethodApiRestServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MethodApiRestServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
