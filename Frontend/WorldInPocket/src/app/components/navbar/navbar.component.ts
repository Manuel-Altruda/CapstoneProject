import { IUser } from './../../interfaces/Iuser';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MenuItem, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RegisterModalComponent } from '../register-modal/register-modal.component';
import { LoginModalComponent } from '../login-modal/login-modal.component';
import { AuthService } from 'src/app/service/auth.service';
import { Dialog } from 'primeng/dialog';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  providers: [DialogService],
})
export class NavbarComponent implements OnInit {

  isLoggingOut: boolean = false;
  user : IUser | null = null;
  userLoggedIn : boolean = false;
  searchQuery : string = '';
  items : MenuItem[] | undefined;
  loading : boolean = false;

  load() {
    this.loading = true;

    setTimeout(() => {
      this.loading = false;
    }, 2000);
  }

  constructor(
    private authSvc: AuthService,
    private dialogService: DialogService,
    public messageService: MessageService
  ) { this.authSvc.isUserLogged.subscribe( user => this.user = user ) }

  ngOnInit() {
    this.userLoggedIn = this.authSvc.isUserLoggedIn();

    this.items = [
      {
        label: 'Messages Center',
        items: [
          {
            label: 'Messaggi',
            icon: 'pi pi-refresh',
            command: () => {
              this.update();
            },
          },
          {
            label: 'notifiche',
            icon: 'pi pi-times',
            command: () => {
              this.delete();
            },
          },
        ],
      },
      {
        label: 'Options',
        items: [
          {
            label: 'Viaggi Prenotati',
            icon: 'pi pi-external-link',
            url: 'http://angular.io',
          },
          {
            label: 'Router',
            icon: 'pi pi-upload',
            routerLink: '/fileupload',
          },
        ],
      },
    ];
  }

  update() {
    this.messageService.add({
      severity: 'success',
      summary: 'Success',
      detail: 'Data Updated',
    });
  }

  delete() {
    this.messageService.add({
      severity: 'warn',
      summary: 'Delete',
      detail: 'Data Deleted',
    });
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
      header: 'Accedi', // Titolo del modale di login
      width: '40%', // Larghezza del modale
      contentStyle: {
        'max-height': '500px', // Altezza massima del contenuto
        overflow: 'auto', // Scroll se il contenuto è troppo grande
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

  ref: DynamicDialogRef | undefined;

  ngOnDestroy() {
    if (this.ref) {
      this.ref.close();
    }
  }

  logout() {
    this.isLoggingOut = true; // Imposta isLoggingOut su true prima del logout
    this.authSvc.logout();
    this.userLoggedIn = false;

    setTimeout(() => {
      this.isLoggingOut = false; // Imposta isLoggingOut su false dopo il logout
      // Puoi anche aggiungere il reindirizzamento qui se necessario
    }, 3000);
  }

}
