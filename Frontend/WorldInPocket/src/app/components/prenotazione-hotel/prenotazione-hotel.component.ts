import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-prenotazione-hotel',
  templateUrl: './prenotazione-hotel.component.html',
  styleUrls: ['./prenotazione-hotel.component.scss']
})
export class PrenotazioneHotelComponent {
  name: string = '';
  email: string = '';
  phone: string = '';
  Street: string = '';
  number: string = '';
  city: string = '';
  postCode: string = '';
  country: string = '';
  dataCheckIn: string = '';
  dataCheckOut: string = '';
  people: Array<string> = [];
  room: Array<string> = [];
  bedding: Array<string> = [];
  comments: Array<string> = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.floatLabel('.floatLabel');
  }

  private floatLabel(inputType: string): void {
    const inputs = document.querySelectorAll<HTMLInputElement>(inputType);

    inputs.forEach((input: HTMLInputElement) => {
      const label = input.nextElementSibling as HTMLElement;

      // on input, check field and add/remove class 'active' to label
      input.addEventListener('input', function () {
        if (input.value === '' || input.value === 'blank') {
          label.classList.remove('active');
        } else {
          label.classList.add('active');
        }
      });
    });
  }
  effettuaPrenotazione() {
    // Creazione di un oggetto con i dati del form
    const prenotazione = {
      name: this.name,
      email: this.email,
      phone: this.phone,
      // Altre proprietà per i dati del form...
    };

    // Invio dei dati al tuo backend Spring Boot tramite una richiesta HTTP POST
    this.http.post('/api/effettua-prenotazione', prenotazione).subscribe(
      (response) => {
        // Gestisci la risposta del backend (ad esempio, reindirizzamento alla pagina di pagamento)
        console.log('Prenotazione effettuata con successo:', response);
        // Reindirizzamento alla pagina di pagamento o altra azione desiderata
      },
      (error) => {
        // Gestisci eventuali errori
        console.error('Errore durante la prenotazione:', error);
      }
    );
  }
}

