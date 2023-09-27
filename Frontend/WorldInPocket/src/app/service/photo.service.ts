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
        const images: any[] = [];
        resolve(images);
      }, 1000);
    });
  }

  private apiUrl = '/api/images';

  constructor(private http: HttpClient) {}

  getAllImages(): Observable<ImageData[]> {
    return this.http.get<ImageData[]>(this.apiUrl);
  }

}
