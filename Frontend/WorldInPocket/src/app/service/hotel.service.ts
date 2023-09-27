import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, filter, map } from 'rxjs';
import { iHotel } from '../interfaces/iHotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private apiUrl = '../../assets/hotel.json';

  constructor(private http: HttpClient) {}

  getAllHotels(): Observable<any[]> {
   return this.http.get<any[]>(this.apiUrl)
      .pipe(
        map((data: any) => data.hotels)
      );
  }

  getHotelById(hotelId: string): Observable<any> {
    return this.getAllHotels().pipe(
      map((hotels: any[]) => {
      console.log(hotels);
      return hotels.find(hotel => hotel.id === hotelId);
    })
  );
  }

}
/* sendJsonData(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/add`, data);
  }

.pipe(
      map((hotels: any[]) => hotels.find(hotel => hotel.id === hotelId))
    );

  getHotelDetails(hotelId: string, token: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    const options = { headers: headers };

    return this.http.get(`${this.apiUrl}/${hotelId}`, options);
  }*/
