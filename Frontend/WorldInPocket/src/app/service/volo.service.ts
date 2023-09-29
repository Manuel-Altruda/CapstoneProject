import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Volo } from '../components/volo-details/volo';

@Injectable({
  providedIn: 'root',
})
export class VoloService {
  private baseUrl = 'http://localhost:8080/api/voli/cerca-voli';
  //private baseUrl = 'https://api.flightapi.io/oneway';
  constructor(private http: HttpClient) {}

  cercaVoli(config: any): Observable<any> {
    if (!config) {
      return throwError("Config object is undefined or null");
    }
    const params = new HttpParams()
      .set('api_key', config.api_key)
      .set('departure_airport_code', config.departure_airport_code)
      .set('arrival_airport_code', config.arrival_airport_code)
      .set('departure_date', config.departure_date)
      .set('number_of_adults', config.number_of_adults.toString())
      .set('cabin_class', config.cabin_class)
      .set('currency', config.currency)
      .set('destinazione', config.destinazione)
      .set('dataCheckIn', config.dataCheckIn)
      .set('dataCheckOut', config.dataCheckOut)
      .set('numeroPasseggeri', config.numeroPasseggeri.toString())
      .set('prezzo', config.prezzo.toString());

    return this.http.get<Volo[]>(`${this.baseUrl}`, { params });
  }

  getVoloById(voloId: number): Observable<Volo> {
    const url = `${this.baseUrl}/${voloId}`;
    return this.http.get<Volo>(`/api/voli/${url}`);
  }
}
