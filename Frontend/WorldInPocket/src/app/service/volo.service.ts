import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Volo } from '../components/volo-details/volo';

@Injectable({
  providedIn: 'root',
})
export class VoloService {
  private baseUrl = 'http://localhost:8080/api/voli';

  constructor(private http: HttpClient) {}

  cercaVoli(formData: any): Observable<any[]> {
    const params = new HttpParams({ fromObject: formData });

    return this.http.get<any[]>(`${this.baseUrl}/cerca-voli`, { params }).pipe(
      catchError((error) => {
        console.error('Errore nella richiesta HTTP', error);
        return throwError('Errore nella richiesta HTTP');
      })
    );
  }

  getVoloById(voloId: number): Observable<Volo> {
    const url = `${this.baseUrl}/${voloId}`;
    return this.http.get<Volo>(url);
  }
}
