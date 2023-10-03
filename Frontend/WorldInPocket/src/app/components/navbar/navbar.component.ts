import { IUser } from './../../interfaces/Iuser';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MenuItem, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RegisterModalComponent } from '../register-modal/register-modal.component';
import { LoginModalComponent } from '../login-modal/login-modal.component';
import { AuthService } from 'src/app/service/auth.service';
import { Dialog } from 'primeng/dialog';
import { Router } from '@angular/router';
import { VoloService } from 'src/app/service/volo.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  providers: [DialogService],
})
export class NavbarComponent implements OnInit {
  isLoggingOut: boolean = false;
  user: IUser | null = null;
  userLoggedIn: boolean = false;
  searchQuery: string = '';
  items: MenuItem[] | undefined;
  loading: boolean = false;
  isMenuOpen = false;

  destinazione: string = '';
  dataCheckIn: string = '';
  dataCheckOut: string = '';
  numeroPasseggeri!: number;
  prezzo!: number;
  @Input() destinazioneInputValue: string = '';
  @Input() dataCheckInInputValue: string = '';
  @Input() dataCheckOutInputValue: string = '';
  @Input() numeroPasseggeriInputValue: number = 0;
  @Input() risultatiRicerca: any[] = [];
  http: any;

  load() {
    this.loading = true;

    setTimeout(() => {
      this.loading = false;
    }, 2000);
  }

  constructor(
    private authSvc: AuthService,
    private dialogService: DialogService,
    public messageService: MessageService,
    private router: Router,
    private voloService: VoloService
  ) {
    this.authSvc.isUserLogged.subscribe((user) => (this.user = user));
  }

  ngOnInit() {
    this.userLoggedIn = this.authSvc.isUserLoggedIn();

    this.items = [
      {
        label: 'Options',
        items: [
          {
            label: 'Profile',
            icon: 'pi pi-user',
            command: () => {
              this.router.navigate(['/profile']);
            },
          },
          {
            label: 'Sign out',
            icon: 'pi pi-sign-out',
            command: () => {
              this.authSvc.logout();
            },
          },
        ],
      },
    ];
  }

  isLoginModalVisible = false;
  isRegisterModalVisible = false;
  visible: boolean = false;

  showLogin: boolean = true;
  showRegister: boolean = false;

  openLoginModal() {
    this.visible = true;
    this.showLogin = true;
    this.showRegister = false;

    this.dialogService.open(LoginModalComponent, {
      header: 'Accedi',
      width: '50%',
      contentStyle: {
        'max-height': '500px',
        overflow: 'auto',
      },
    });
    this.isLoginModalVisible = true;
  }
  openRegisterModal() {
    this.visible = true;

    this.dialogService.open(RegisterModalComponent, {
      header: 'Registrati',
      width: '40%',
      contentStyle: {
        'max-height': '500px',
        overflow: 'auto',
      },
    });
    this.isRegisterModalVisible = true;
  }

  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen;
    console.log('Menu is open:', this.isMenuOpen);
  }

  ref: DynamicDialogRef | undefined;

  ngOnDestroy() {
    if (this.ref) {
      this.ref.close();
    }
  }

  logout() {
    this.isLoggingOut = true;
    this.authSvc.logout();
    this.userLoggedIn = false;

    setTimeout(() => {
      this.isLoggingOut = false;
    }, 1000);
  }

  options: any[] = [
    { label: 'Opzione 1', value: 'opzione1' },
    { label: 'Opzione 2', value: 'opzione2' },
    { label: 'Opzione 3', value: 'opzione3' },
  ];
  selectedOption: any;

  cercaVoli() {
    const config = {
      api_key: '6501f56d9b605a57eb792907',
      departure_airport_code: 'JAI',
      arrival_airport_code: 'GOA',
      departure_date: '2023-07-05',
      number_of_adults: 1,
      cabin_class: 'economy',
      currency: 'USD',
      destinazione: this.destinazione,
      dataCheckIn: this.dataCheckIn,
      dataCheckOut: this.dataCheckOut,
      numeroPasseggeri: this.numeroPasseggeri,
      prezzo: this.prezzo,
    };

    this.voloService
      .cercaVoli(config)
      .subscribe((risultati) => {
        this.risultatiRicerca = risultati;
        console.log('Risultati della ricerca:', risultati);
      });
  }
}
