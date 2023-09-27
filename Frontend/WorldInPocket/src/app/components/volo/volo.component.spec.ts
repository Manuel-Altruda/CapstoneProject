import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoloComponent } from './volo.component';

describe('VoloComponent', () => {
  let component: VoloComponent;
  let fixture: ComponentFixture<VoloComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VoloComponent]
    });
    fixture = TestBed.createComponent(VoloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
