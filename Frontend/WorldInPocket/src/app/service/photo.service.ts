import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {
  getImages(): Promise<any[]> {
    // Effettua la chiamata HTTP o l'operazione asincrona per ottenere le immagini
    // e restituisci una promessa con i dati delle immagini quando è completata.
    return new Promise<any[]>((resolve) => {
      // Simulazione di una chiamata asincrona
      setTimeout(() => {
        const images: any[] = [/* ... array di immagini ... */];
        resolve(images);
      }, 1000); // Esempio di ritardo simulato di 1 secondo
    });
  }


constructor() { }

}
