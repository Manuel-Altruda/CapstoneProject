import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayErrorComponent } from './pay-error.component';

describe('PayErrorComponent', () => {
  let component: PayErrorComponent;
  let fixture: ComponentFixture<PayErrorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PayErrorComponent]
    });
    fixture = TestBed.createComponent(PayErrorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
