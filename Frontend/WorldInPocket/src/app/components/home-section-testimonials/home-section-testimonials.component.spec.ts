import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeTravelTestimonialsComponent } from './home-section-testimonials.component';

describe('HomeTravelTestimonialsComponent', () => {
  let component: HomeTravelTestimonialsComponent;
  let fixture: ComponentFixture<HomeTravelTestimonialsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeTravelTestimonialsComponent]
    });
    fixture = TestBed.createComponent(HomeTravelTestimonialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
