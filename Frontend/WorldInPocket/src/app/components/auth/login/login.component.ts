import { Component, ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { IloginUser } from 'src/app/interfaces/IloginUser';
import { IUser } from 'src/app/interfaces/Iuser';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  user: IloginUser = {
    username: '',
    password: '',
  };
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.user).subscribe(
      (response: any) => {
        console.log('Risposta dal server:', response);
        this.router.navigate(['/dashboard']);

      },
      (error: any) => {
        console.error('Errore durante il login:', error);
        this.errorMessage = 'Credenziali non valide. Riprova.';
      }
    );
  }

}
