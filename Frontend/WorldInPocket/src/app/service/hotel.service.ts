import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http: HttpClient) {}

  private hotelsJson = '../../assets/hotel.json';

  getHotelDetails(hotelId: string): Observable<any> {
    return this.http.get<any[]>(this.hotelsJson).pipe(
      map(hotels => hotels.find(hotel => hotel.hotelId === hotelId))
    );
  }

  getHotelById(hotelId: string): Observable<any> {
    return this.http.get(this.hotelsJson).pipe(
      map((data: any) => {
        if (data.hotels && data.hotels[hotelId]) {
          return data.hotels[hotelId];
        } else {
          throw new Error(`Hotel with ID ${hotelId} not found`);
        }
      })
    );
  }

 /* getHotels(): Observable<any[]> {
    return this.http.get<any[]>('../images/hotel1.jpg');
  }
  */
}
