import { Iprenotazione } from './../interfaces/Iprenotazione';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Iricevuta } from '../interfaces/Iricevuta';
import { environment } from 'src/environments/environment.development';
import { RicevutaSkl } from '../interfaces/ricevutaSkl';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService {
  private ricevutaSubject: BehaviorSubject<Iprenotazione | undefined> = new BehaviorSubject<Iprenotazione | undefined>( undefined );

constructor(private http: HttpClient) {
  let ricevutaStorage: Iprenotazione = JSON.parse( sessionStorage.getItem( 'prenotazione' ) ! );
  if (ricevutaStorage) {
    this.ricevutaSubject.next (ricevutaStorage)
  }
}

setPrenotazione(prenotazione: Iprenotazione): void {
  sessionStorage.setItem('prenotazione', JSON.stringify(prenotazione));
  this.ricevutaSubject.next (prenotazione);
  console.log (prenotazione);
}

getPrenotazione(): Observable<Iprenotazione | undefined> {
  return this.ricevutaSubject.asObservable();
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


