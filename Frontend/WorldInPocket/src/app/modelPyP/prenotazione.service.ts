import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, of, tap } from 'rxjs';
import { Iricevuta } from '../interfaces/Iricevuta';
import { environment } from 'src/environments/environment.development';
import { RicevutaSkl } from '../interfaces/ricevutaSkl';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService {
  protected ricevuta ?: Iricevuta;
  private prenotazioneSubject: BehaviorSubject<Iricevuta | undefined> = new BehaviorSubject<Iricevuta | undefined>(
    undefined
  );

// private prenotazione : Iricevuta

constructor(private http: HttpClient) { }



setPrenotazione(prenotazione: Iricevuta): void {
  this.ricevuta = prenotazione;
  this.prenotazioneSubject.next(prenotazione);
}

getPrenotazione(): Observable<Iricevuta | undefined> {
  return this.prenotazioneSubject.asObservable();
}


setRoomType(roomType: string) {
  if (this.ricevuta) {
    this.ricevuta.roomType = roomType;
  }
}

getRoomType(): string {
  return this.ricevuta?.roomType || '';
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

prenotazione(ricevuta:Iricevuta, orderID: string){
  ricevuta.orderID = orderID;
  return this.http.post(environment.ricevuta, ricevuta);
}

setRicevuta(ricevuta:Iricevuta){
  this.ricevuta=ricevuta;
  sessionStorage.setItem("ricevuta", JSON.stringify(ricevuta));
}

getRicevuta(){
  if(this.ricevuta) return this.ricevuta;
  let ricevuta=JSON.parse(sessionStorage.getItem("ricevuta")!);
  if(ricevuta) return ricevuta;
}

getHotelPrice(hotelId: string): Observable<number> {
  return this.http.get<number>(`/api/hotels/${hotelId}/price`);
}

}


