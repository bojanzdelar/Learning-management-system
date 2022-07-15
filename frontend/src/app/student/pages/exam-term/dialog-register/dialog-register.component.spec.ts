import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogRegisterComponent } from './dialog-register.component';

describe('DialogRegisterComponent', () => {
  let component: DialogRegisterComponent;
  let fixture: ComponentFixture<DialogRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
