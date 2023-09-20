import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-prenotazione-hotel',
  templateUrl: './prenotazione-hotel.component.html',
  styleUrls: ['./prenotazione-hotel.component.scss']
})
export class PrenotazioneHotelComponent {
  prenotazioneForm: FormGroup;

  name: string = '';
  email: string = '';
  phone: string = '';
  street: string = '';
  streetNumber: string = '';
  number: string = '';
  city: string = '';
  postCode: string = '';
  country: string = '';
  arrive: string = '';
  depart: string = '';
  people: Array<string> = [];
  room: Array<string> = [];
  bedding: Array<string> = [];
  comments: Array<string> = [];


  showValidationError = false;

  constructor(private http: HttpClient, private router: Router, private fb: FormBuilder) {
    this.prenotazioneForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      street: ['', Validators.required],
      streetNumber: ['', Validators.required],
      city: ['', Validators.required],
      postCode: ['', Validators.required],
      people: ['', Validators.required],
      country: ['', Validators.required],
      arrive: ['', Validators.required],
      depart: ['', Validators.required],
      comments: ['']
    });
  }

  isFormValid(): boolean {
    return this.prenotazioneForm.valid;
  }

  ngOnInit(): void {
    this.floatLabel('.floatLabel');
  }

  private floatLabel(inputType: string): void {
    const inputs = document.querySelectorAll<HTMLInputElement>(inputType);

    inputs.forEach((input: HTMLInputElement) => {
      const label = input.nextElementSibling as HTMLElement;

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
    if (this.isFormValid()) {
      const prenotazione = {
        name: this.prenotazioneForm.get('name'),
        email: this.prenotazioneForm.get('email'),
        phone: this.prenotazioneForm.get('phone'),
        street: this.prenotazioneForm.get('street'),
        streetNumber: this.prenotazioneForm.get('streetNumber'),
        city: this.prenotazioneForm.get('city'),
        postCode: this.prenotazioneForm.get('postCode'),
        people: this.prenotazioneForm.get('people'),
        country: this.prenotazioneForm.get('country'),
        arrive: this.prenotazioneForm.get('arrive'),
        depart: this.prenotazioneForm.get('depart'),
        comments: this.prenotazioneForm.get('comments'),
        // Aggiungi gli altri campi del form
      };


    this.http.post('/api/effettua-prenotazione', prenotazione).subscribe(
      (response) => {

        console.log('Prenotazione effettuata con successo:', response);

      },
      (error) => {
        console.error('Errore durante la prenotazione:', error);
      }
    );
  }
  }
  navigateToPaymentPage(){
    this.router.navigate(['/pagamento']);
  }


}
