import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http: HttpClient) {}



  getHotels(): Observable<any[]> {
    return this.http.get<any[]>('../images/hotel1.jpg'); // Assicurati che il percorso sia corretto
  }

}
