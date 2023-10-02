import { Iprenotazione } from './../interfaces/Iprenotazione';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Iricevuta } from '../interfaces/Iricevuta';
import { environment } from 'src/environments/environment.development';
import { RicevutaSkl } from '../interfaces/ricevutaSkl';
import { HttpClient } from '@angular/common/http';
import { iHotel } from '../interfaces/iHotel';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService {
  private ricevutaSubject: BehaviorSubject<Iprenotazione | undefined> = new BehaviorSubject<Iprenotazione | undefined>( undefined );
  private hotelSubject: BehaviorSubject<iHotel | undefined> = new BehaviorSubject<iHotel | undefined>( undefined );

constructor(private http: HttpClient) {
  let ricevutaStorage: Iprenotazione = JSON.parse( sessionStorage.getItem( 'prenotazione' ) ! );
  let hotelStorage: iHotel = JSON.parse( sessionStorage.getItem( 'hotel' ) ! );

  if (ricevutaStorage) {
    this.ricevutaSubject.next (ricevutaStorage)
  }
  if (hotelStorage) {
    this.hotelSubject.next (hotelStorage)
  }
}

setHotel(hotel: iHotel): void {
  sessionStorage.setItem('hotel', JSON.stringify(hotel));
  this.hotelSubject.next (hotel);
  console.log ("Set hotel:", hotel);
}

setPrenotazione(prenotazione: Iprenotazione): void {
  sessionStorage.setItem('prenotazione', JSON.stringify(prenotazione));
  this.ricevutaSubject.next (prenotazione);
  console.log ("Set prenotazione:", prenotazione);
}

getPrenotazione(): Observable<Iprenotazione | undefined> {
  return this.ricevutaSubject.asObservable();
}

getHotel(){
  return this.hotelSubject.asObservable();
}

/*inviaDettagliPrenotazione(dettagli: any): Observable<any> {
  const url = 'http://localhost:8080/prenotazione';
  return this.http.post(url, dettagli).pipe(
    tap(() => {

      console.log('Dettagli della prenotazione inviati con successo.');

    }),
    catchError((error) => {
      console.error('Errore nell\'invio dei dettagli della prenotazione:', error);
      return of(null);
    })
  );
}*/

  selectedRoomType: string = '';
  numberOfGuests: number = 1;
  selectedHotel: any = null;

reset() {
  this.selectedRoomType = '';
  this.numberOfGuests = 1;
  this.selectedHotel = null;
}

creaPrenotazione(prenotazione:Iprenotazione){
  return this.http.post(environment.ricevuta, prenotazione);
}

getHotelPrice(hotelId: string): Observable<number> {
  return this.http.get<number>(`/api/hotels/${hotelId}/price`);
}

}


