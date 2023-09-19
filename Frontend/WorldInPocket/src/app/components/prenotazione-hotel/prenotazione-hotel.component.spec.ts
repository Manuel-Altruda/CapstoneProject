import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotazioneHotelComponent } from './prenotazione-hotel.component';

describe('PrenotazioneHotelComponent', () => {
  let component: PrenotazioneHotelComponent;
  let fixture: ComponentFixture<PrenotazioneHotelComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrenotazioneHotelComponent]
    });
    fixture = TestBed.createComponent(PrenotazioneHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
