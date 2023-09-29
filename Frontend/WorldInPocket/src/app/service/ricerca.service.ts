import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RicercaService {

  constructor(private http: HttpClient) {}

  cercaVoli(
    api_key: string,
    departure_airport_code: string,
    arrival_airport_code: string,
    departure_date: string,
    number_of_adults: number,
    cabin_class: string,
    currency: string
  ): Observable<any[]> {
    const url = 'https://api.flightapi.io/oneway';
    return this.http.get<any[]>(url, {
      params: {
        api_key,
        departure_airport_code,
        arrival_airport_code,
        departure_date,
        number_of_adults: number_of_adults.toString(),
        cabin_class,
        currency,
      },
    });
  }
}
