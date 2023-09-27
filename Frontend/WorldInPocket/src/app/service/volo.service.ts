import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Volo } from '../components/volo-details/volo';

@Injectable({
  providedIn: 'root'
})
export class VoloService {
  private baseUrl = 'http://localhost:8080/api/voli';

  constructor(private http: HttpClient) {}

  cercaVoli(destinazione: string, dataCheckIn: string, dataCheckOut: string, numeroPasseggeri: number, prezzo: number): Observable<any[]> {
    const url = `${this.baseUrl}/cerca-voli?destinazione=${destinazione}&dataCheckIn=${dataCheckIn}&dataCheckOut=${dataCheckOut}&numeroPasseggeri=${numeroPasseggeri}&prezzo=${prezzo}`;

    return this.http.get<any[]>(url);
  }

  getVoloById(voloId: number): Observable<Volo> {
    const url = `${this.baseUrl}/${voloId}`;
    return this.http.get<Volo>(`/api/voli/${url}`);
  }

}
