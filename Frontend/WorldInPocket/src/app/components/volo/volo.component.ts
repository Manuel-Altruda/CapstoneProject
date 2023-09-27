import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VoloService } from 'src/app/service/volo.service';

@Component({
  selector: 'app-volo',
  templateUrl: './volo.component.html',
  styleUrls: ['./volo.component.scss']
})
export class VoloComponent implements OnInit {
  responsiveOptions: any[] | undefined;
  destinazione: string = '';
  dataCheckIn: string = '';
  dataCheckOut: string = '';
  numeroPasseggeri!: number ;
  prezzo!: number;
  voli: any[] | undefined ;
  volo: any;
  constructor(private voloSvc: VoloService, private router: Router, private http: HttpClient) {}

  ngOnInit(): void { }
  cercaVoli() {

    this.voloSvc.cercaVoli(this.destinazione, this.dataCheckIn, this.dataCheckOut, this.numeroPasseggeri, this.prezzo)
      .subscribe((result) => {
        this.voli = result;
      });
  }

  vaiADettaglioVolo(id: number) {
    this.router.navigate(['dettaglio-volo', id]);
  }
}
