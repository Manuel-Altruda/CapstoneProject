import { Iprenotazione } from './../../interfaces/Iprenotazione';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Iricevuta } from 'src/app/interfaces/Iricevuta';
import { IUser } from 'src/app/interfaces/Iuser';
import { iHotel } from 'src/app/interfaces/iHotel';
import { PrenotazioneService } from 'src/app/modelPyP/prenotazione.service';
import { AuthService } from 'src/app/service/auth.service';
import { HotelService } from 'src/app/service/hotel.service';
//import { PrenotazioneService } from 'src/app/modelPyP/prenotazione.service';

@Component({
  selector: 'app-prenotazione-hotel',
  templateUrl: './prenotazione-hotel.component.html',
  styleUrls: ['./prenotazione-hotel.component.scss'],
})
export class PrenotazioneHotelComponent {
  prenotazioneForm: FormGroup;
  orderID !: string;
  Iprenotazione !: Iprenotazione;
  showValidationError = false;
  hotelId: any;
  user !: IUser;
  hotel !: iHotel;
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
    private route : ActivatedRoute,
    private fb: FormBuilder,
    private authSvc : AuthService,
    private hotelSvc : HotelService,
    private prenotazioneService: PrenotazioneService
  ) {
    authSvc.isUserLogged.subscribe(u => this.user != u)
    hotelSvc.getHotelById(route.snapshot.paramMap.get("id")!).subscribe(hotel => this.hotel = hotel)


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
    const ricevuta : Iricevuta = {
      roomType: '',
      orderID: '',
      user: this.user
    }

    console.log(this.prenotazioneForm.value);
  }

  navigateToPaymentPage() {
    if (this.isFormValid()) {
      this.router.navigate(['/pagamento']);
    }
  }
}
