import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VoloService } from 'src/app/service/volo.service';
import { Volo } from './volo';

@Component({
  selector: 'app-volo-details',
  templateUrl: './volo-details.component.html',
  styleUrls: ['./volo-details.component.scss'],
  template: `

  <div *ngFor = "let volo of voli">
    <div class="flight-card">
      {{ volo.destinazione }} - {{ volo.checkInDate }} to {{  volo.checkOutDate }}

      Viaggiatori: {{ volo.nuemeroPasseggeri }}, Prezzo: {{  volo.prezzo }}
    </div>
  </div>

  `
})


export class VoloDetailsComponent implements OnInit {
  volo: any;
  voli: Volo[] = [];

  constructor(private route: ActivatedRoute, private voloSvc: VoloService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const voloId = +params['id']; // Ottieni l'ID del volo dalla route
      this.voloSvc.getVoloById(voloId).subscribe(result => {
        this.volo = result;
      });
    });
  }


  getVoloDetails(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.voloSvc.getVoloById(id)
      .subscribe(
        volo => this.volo = volo,
        error => {
          console.error('Errore durante la chiamata al servizio:', error);
        }
      );
  }

  cercaVoli(destinazione: string, dataCheckIn: string, dataCheckOut: string, numeroViaggiatori: number, prezzo: number) {
    this.voloSvc.cercaVoli(destinazione, dataCheckIn, dataCheckOut, numeroViaggiatori, prezzo)
    .subscribe((voli) => {
      this.voli = voli;
    })
  }

}
