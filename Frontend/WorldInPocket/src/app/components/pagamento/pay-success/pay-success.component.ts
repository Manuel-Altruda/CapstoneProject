import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-pay-success',
  templateUrl: './pay-success.component.html',
  styleUrls: ['./pay-success.component.scss']
})
export class PaySuccessComponent implements OnInit {
  showSpinner = false;
  numeroOrdine!: string;
  importoPagato!: number;
  nomeAcquirente!: string;
  emailAcquirente!: string;

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    setTimeout(() => {
      this.showSpinner = true;
      setTimeout(() => {
        this.router.navigate(['/dashboard']);
      }, 2000);
    }, 1500);

    this.numeroOrdine = '4897416132144';
    this.importoPagato = 790.00;
    this.nomeAcquirente = 'John Doe';
    this.emailAcquirente = 'sb-yng47u27594608@personal.example.com';
  }

}
