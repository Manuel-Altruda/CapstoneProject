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
  dataPartenza:any;
  dataArrivo:any;

  constructor(
    private http: HttpClient,
    private router: Router,
    private route : ActivatedRoute,
    private fb: FormBuilder,
    private authSvc : AuthService,
    private hotelSvc : HotelService,
    private prenotazioneService: PrenotazioneService
  ) {
    authSvc.isUserLogged.subscribe(u => this.user = u!)
    //hotelSvc.getHotelById(route.snapshot.paramMap.get("hotelId")!).subscribe(hotel => {this.hotel = hotel; console.log(hotel)})
    route.queryParams.subscribe(params=>{
      console.log(params);
      this.dataPartenza=params['checkIn'];
      this.dataArrivo=params['checkOut'];
      hotelSvc.getHotelById(params['hotelId']).subscribe(hotel=> this.hotel=hotel);
    })

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
      bedding: ['', Validators.required],
      roomType: ['', Validators.required],
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
    const prenotazione : Iprenotazione = {
      hotel: this.hotel,
      user: this.user,
      details: this.prenotazioneForm.value,
      payer: this.prenotazioneForm.value
    }

    const linkPaypal = "https://www.sandbox.paypal.com?cmd=_cart&business=sb-k1jk625923792@business.example.com&upload=1&currency_code=EUR&item_name_1="+this.hotel.name+"&item_number_1=1&amount_1=790&shipping_1=0&cancel_return=http://localhost:4200/pay-error&return=http://localhost:4200/pay-success";



    prenotazione.details.arrive=this.dataArrivo;
    prenotazione.details.depart=this.dataPartenza;

    console.log("Submit: ", prenotazione)

    this.prenotazioneService.setPrenotazione(prenotazione);
   // this.router.navigate(['/pagamento']);
    window.open(linkPaypal);

  }



}
