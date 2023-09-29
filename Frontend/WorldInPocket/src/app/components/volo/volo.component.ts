import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
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
  destinazione: string = '';
  dataCheckIn: string = '';
  dataCheckOut: string = '';
  numeroPasseggeri: number = 1;
  prezzo: number = 0;
  voli: any[] | undefined;
  volo: any;
  @Input() risultatiRicerca: any[] = [];

  constructor(
    private voloSvc: VoloService,
    private router: Router,
    private ricercaService: RicercaService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {}
  cercaVoli() {
    if (this.destinazione && this.dataCheckIn && this.dataCheckOut && this.numeroPasseggeri && this.prezzo) {
      const config = {
        api_key: '6501f56d9b605a57eb792907',
        departure_airport_code: this.destinazione,
        arrival_airport_code: this.destinazione,
        departure_date: this.dataCheckIn,
        number_of_adults: this.numeroPasseggeri,
        cabin_class: 'economy',
        currency: 'USD',
        destinazione: this.destinazione,
        dataCheckIn: this.dataCheckIn,
        dataCheckOut: this.dataCheckOut,
        numeroPasseggeri: this.numeroPasseggeri,
      };

      this.voloSvc.cercaVoli(config).subscribe((risultati) => {
        this.risultatiRicerca = risultati;
        console.log('Risultati della ricerca:', risultati);
      });
    } else {
      console.error('Alcune variabili non sono definite o hanno valori mancanti.');
    }
  }

  vaiADettaglioVolo(id: number) {
    this.router.navigate(['volo-details', id]);
  }
}
