import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pay-success',
  templateUrl: './pay-success.component.html',
  styleUrls: ['./pay-success.component.scss']
})
export class PaySuccessComponent implements OnInit {

  numeroOrdine!: string;
  importoPagato!: number;
  nomeAcquirente!: string;
  emailAcquirente!: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    // Ottieni i dati dinamici dall'URL o da un servizio
    this.numeroOrdine = '123456';
    this.importoPagato = 100.00;
    this.nomeAcquirente = 'Nome Acquirente';
    this.emailAcquirente = 'email@example.com';
  }

}
