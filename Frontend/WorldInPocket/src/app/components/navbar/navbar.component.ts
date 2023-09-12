import { Component, OnInit } from '@angular/core';
import { MenuItem, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { RegisterModalComponent } from '../register-modal/register-modal.component';
import { LoginModalComponent } from '../login-modal/login-modal.component';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  providers: [DialogService]
})
export class NavbarComponent implements OnInit {
  searchQuery: string = '';
  items: MenuItem[] | undefined;
  loading: boolean = false;

  load() {
      this.loading = true;

      setTimeout(() => {
          this.loading = false
      }, 2000);
  }

  constructor(private dialogService: DialogService, public messageService: MessageService) {}

  ngOnInit() {

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
    width: '40%',   // Larghezza del modale
    contentStyle: {
      'max-height': '500px', // Altezza massima del contenuto
      overflow: 'auto'       // Scroll se il contenuto è troppo grande
    }
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
      overflow: 'auto'
    }
  });
  this.isRegisterModalVisible = true;
}


    ref: DynamicDialogRef | undefined;


    ngOnDestroy() {
        if (this.ref) {
            this.ref.close();
        }
    }

}



