import { PrenotazioneService } from './../../modelPyP/prenotazione.service';
import { Iricevuta } from './../../interfaces/Iricevuta';
import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {
  ConfirmEventType,
  ConfirmationService,
  MessageService,
} from 'primeng/api';
import { IUser } from 'src/app/interfaces/Iuser';
import { AuthService } from 'src/app/service/auth.service';
import { environment } from 'src/environments/environment.development';

declare var paypal: any;

@Component({
  selector: 'app-pagamento',
  templateUrl: './pagamento.component.html',
  styleUrls: ['./pagamento.component.scss'],
  providers: [ConfirmationService, MessageService],
})
export class PagamentoComponent implements OnInit {

  @ViewChild('paypal', { static: true }) paypalElement!: ElementRef;

  private user: IUser | null = null;
  Iricevuta!: Iricevuta;
  paypalInitialized: boolean = false;
  selectedRoomType: string = '';
  numberOfGuests: number = 1;
  selectedHotel: any;
  hotelId: string = '';
  orderID: string = '';
  ricevutaDTO: any;

  constructor(
    private authSvc: AuthService,
    private prenotazioneSvc: PrenotazioneService,
    private confirmationService: ConfirmationService,
    private messageService: MessageService,
    private router: Router,
    private http: HttpClient,
    private route: ActivatedRoute
  ) {
    authSvc.isUserLogged.subscribe((u) => {this.user = u
    console.log(this.user)} );

  }

  ngOnInit(): void {

    console.log('RicevutaDTO:', this.Iricevuta);
    this.route.params.subscribe((params) => {
      this.hotelId = params['hotelId'];
    });
    this.route.queryParams.subscribe((queryParams) => {
      this.orderID = queryParams['orderID'];
    });

    let payPalButtons = paypal
      .Buttons({
        createOrder: (data: any) => {
          console.log(this.Iricevuta);
          const ricevutaDTO = {
            orderID: this.hotelId,
            user: {
              username: this.user?.username || '',
              accessToken: this.user?.accessToken || '',
              tokenType: 'Bearer',
            },
            prenotazioni: [
              {

              }
            ],
          };
          return fetch(environment.payments, {
            method: 'POST',
            headers: {
              Authorization: 'Bearer ' + this.user!.accessToken,
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(ricevutaDTO),
          })
            .then((res) => res.text())
            .then(id => {
              console.log('Risposta PayPal:', id);
              this.orderID = id;
              return id;
            });
        },
        onApprove: (data: any, actions: any) => {
          console.log(data);
          return fetch(environment.payments + `/${this.orderID}`, {
            method: 'POST',
            headers: {
              Authorization: 'Bearer ' + this.user!.accessToken,
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({ orderID: this.orderID }),
          })
            .then((response) => response.json())
            .then((json) => {
              this.prenotazioneSvc
                .prenotazione(this.Iricevuta, this.orderID)
                .subscribe((data: any) => {
                  this.prenotazioneSvc.reset();
                  this.router.navigate(['/pay-success']);
                  this.router.resetConfig([]);
                });
            });
        },
      })
      .render(this.paypalElement.nativeElement);
  }

  confirm1() {
    this.confirmationService.confirm({
      message: 'Are you sure that you want to proceed?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.messageService.add({
          severity: 'info',
          summary: 'Confirmed',
          detail: 'You have accepted',
        });
      },
      reject: (type: ConfirmEventType) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            this.messageService.add({
              severity: 'error',
              summary: 'Rejected',
              detail: 'You have rejected',
            });
            break;
          case ConfirmEventType.CANCEL:
            this.messageService.add({
              severity: 'warn',
              summary: 'Cancelled',
              detail: 'You have cancelled',
            });
            break;
        }
      },
    });
  }
}

/* this.Iricevuta = {
      orderID: this.hotelId,
      user: {
        username: this.user?.username || '',
        accessToken: this.user?.accessToken || '',
        tokenType: 'Bearer',
      },
      prenotazioni: [],

    }; */
