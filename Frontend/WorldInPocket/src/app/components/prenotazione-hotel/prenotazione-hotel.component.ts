import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Iricevuta } from 'src/app/interfaces/Iricevuta';
import { IUser } from 'src/app/interfaces/Iuser';
import { PrenotazioneService } from 'src/app/modelPyP/prenotazione.service';
//import { PrenotazioneService } from 'src/app/modelPyP/prenotazione.service';

@Component({
  selector: 'app-prenotazione-hotel',
  templateUrl: './prenotazione-hotel.component.html',
  styleUrls: ['./prenotazione-hotel.component.scss'],
})
export class PrenotazioneHotelComponent {
  prenotazioneForm: FormGroup;
  orderID!: string;
  Iricevuta: any;
  showValidationError = false;
  hotelId: any;
  user: any;

  /*
  Iricevuta: Iricevuta = {
    orderID: '', // Inizializza con i valori predefiniti o vuoti
    user: {} as IUser, // Inizializza con i valori predefiniti o vuoti
    roomType: '',
    numberOfGuests: 0,
    id: this.orderID,
    selectedHotel: null, // Inizializza con i valori predefiniti o vuoti
    prenotazioni: [],
    captureTime: new Date(),
    totPrice: 0,
  };*/



  constructor(
    //private prenotazioneService: PrenotazioneService,
    private http: HttpClient,
    private router: Router,
    private fb: FormBuilder,
    private prenotazioneService: PrenotazioneService
  ) {
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
      comments: [''],
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

  isFormControlValid(fieldName: string): boolean {
    const control = this.prenotazioneForm.get(fieldName);
    return control?.valid || false;
  }

  effettuaPrenotazione() {
    if (this.prenotazioneForm.valid) {
      const dettagliPrenotazione = {
        orderID: this.hotelId,
        user: {
          username: this.user?.username || '',
          accessToken: this.user?.accessToken || '',
          tokenType: 'Bearer',
        },
        prenotazioni: [
          {
            name: this.prenotazioneForm.get('name')?.value,
            email: this.prenotazioneForm.get('email')?.value,
            phone: this.prenotazioneForm.get('phone')?.value,
            street: this.prenotazioneForm.get('street')?.value,
            streetNumber: this.prenotazioneForm.get('streetNumber')?.value,
            city: this.prenotazioneForm.get('city')?.value ?? '',
            postCode: this.prenotazioneForm.get('postCode')?.value,
            country: this.prenotazioneForm.get('country')?.value,
            arrive: this.prenotazioneForm.get('arrive')?.value,
            depart: this.prenotazioneForm.get('depart')?.value,
            people: this.prenotazioneForm.get('people')?.value,
            roomType: this.prenotazioneForm.get('roomType')?.value,
            numberOfGuests: this.prenotazioneForm.get('numberOfGuests')?.value,
          }
        ],
      };
      this.Iricevuta = {
        orderID: this.hotelId,
        user: {
          username: this.user?.username || '',
          accessToken: this.user?.accessToken || '',
          tokenType: 'Bearer',
        },
        prenotazioni: dettagliPrenotazione.prenotazioni,
      };


  }
  }
  navigateToPaymentPage() {
    if (this.isFormValid()) {
      this.router.navigate(['/pagamento']);
    }
  }
}
