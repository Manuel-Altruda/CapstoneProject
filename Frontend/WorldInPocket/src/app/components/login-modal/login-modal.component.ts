import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-login-modal',
  templateUrl: './login-modal.component.html',
  styleUrls: ['./login-modal.component.scss']
})
export class LoginModalComponent {

  loginData = {
    email: '',
    password: '',
  };

  @Output() loginClicked = new EventEmitter<any>();

  login() {
    // Invia i dati di accesso al componente padre
    this.loginClicked.emit(this.loginData);
  }

}
