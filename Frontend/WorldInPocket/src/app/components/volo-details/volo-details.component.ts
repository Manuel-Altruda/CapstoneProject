import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VoloService } from 'src/app/service/volo.service';
import { Volo } from './volo';

@Component({
  selector: 'app-volo-details',
  templateUrl: './volo-details.component.html',
  styleUrls: ['./volo-details.component.scss'],

})


export class VoloDetailsComponent implements OnInit {
  volo: any;
  voli: Volo[] = [];
  id !: number;

  constructor(private route: ActivatedRoute, private voloSvc: VoloService) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get("id"));
  }


  getVoloDetails(): void {
    this.voloSvc.getVoloById(this.id)
      .subscribe(
        volo => this.volo = volo,
        error => {
          console.error('Errore durante la chiamata al servizio:', error);
        }
      );
  }

 /* cercaVoli(destinazione: string, dataCheckIn: string, dataCheckOut: string, numeroViaggiatori: number, prezzo: number) {
    this.voloSvc.cercaVoli(destinazione, dataCheckIn, dataCheckOut, numeroViaggiatori, prezzo)
    .subscribe((voli) => {
      this.voli = voli;
    })
  }*/

}
