import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {
  getImages(): Promise<any[]> {
    return new Promise<any[]>((resolve) => {
      setTimeout(() => {
        const images: any[] = [/* ... array di immagini ... */];
        resolve(images);
      }, 1000); // Esempio di ritardo simulato di 1 secondo
    });
  }

  private apiUrl = '/api/images';

  constructor(private http: HttpClient) {}

  getAllImages(): Observable<ImageData[]> {
    return this.http.get<ImageData[]>(this.apiUrl);
  }

}
