import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoloDetailsComponent } from './volo-details.component';

describe('VoloDetailsComponent', () => {
  let component: VoloDetailsComponent;
  let fixture: ComponentFixture<VoloDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VoloDetailsComponent]
    });
    fixture = TestBed.createComponent(VoloDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
