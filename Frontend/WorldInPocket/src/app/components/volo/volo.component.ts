import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RicercaService } from 'src/app/service/ricerca.service';
import { VoloService } from 'src/app/service/volo.service';

@Component({
  selector: 'app-volo',
  templateUrl: './volo.component.html',
  styleUrls: ['./volo.component.scss'],
})
export class VoloComponent implements OnInit {
  responsiveOptions: any[] | undefined;
  searchForm !: FormGroup;
  @Input() flightResults: any[] = [];
  risultatiRicerca: any[] = [];

  constructor(
    private voloSvc: VoloService,
    private router: Router,
    private formBuilder: FormBuilder,
    private http: HttpClient
  ) {
    this.searchForm = this.formBuilder.group({
      trip: ['Round Trip', Validators.required],
      origin: ['', Validators.required],
      destinazione: ['', Validators.required],
      dataCheckIn: ['', [Validators.required, this.dateFormatValidator]],
      dataCheckOut: [''] ,
      numeroPasseggeri: [1, [Validators.required, Validators.min(1), Validators.max(400)]]
    });

  }

  dateFormatValidator = Validators.pattern(/^\d{4}-\d{2}-\d{2}$/);

  ngOnInit(): void {
   /* this.searchForm = this.formBuilder.group({
      trip: ['Road Trip', Validators.required],
      fromPlace: ['', Validators.required],
      toPlace: ['', Validators.required],
      travelDate: ['', [Validators.required, this.dateFormatValidator]],
      returnDate: [''],
      noOfTravelers: [1, [Validators.required, Validators.min(1), Validators.max(8)]]
    });*/
  }

  onSubmit() {
    console.log('SUBMIT CLICK');
    if (this.searchForm.valid) {
      const formData = this.searchForm.value;
      const params = new HttpParams({ fromObject: formData });

      this.voloSvc.cercaVoli(formData).subscribe(
        (response: any) => {
          console.log('HTTP request successful:', response);
          this.flightResults = response;
          /*this.router.navigate(['/volo-details'], { state: { results: this.flightResults } });*/
        },
        (error) => {
          console.error('Errore nella richiesta HTTP:', error);
        }
      );
    } else {
      alert('Per favore, completa tutti i campi obbligatori e verifica i dati inseriti.');
    }
  }




  vaiADettaglioVolo(id: number) {
    this.router.navigate(['volo-details', id]);
  }


}
