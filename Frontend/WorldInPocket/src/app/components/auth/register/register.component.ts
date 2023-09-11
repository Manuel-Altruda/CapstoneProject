import { Component, ElementRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { IUser } from 'src/app/interfaces/Iuser';
import { AuthService } from 'src/app/service/auth.service';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  user: any = {
    name: '',
    lastname: '',
    email: '',
    username: '',
    password: ''
  };
  errorMessage: string = '';

  constructor(private authService: AuthService,  private router: Router) {}

  register() {
    this.authService.register(this.user).subscribe(
      (response) => {
        console.log('Risposta dal server:', response);
        this.router.navigate(['/login']);
      },
      (error) => {
        console.error('Errore durante la registrazione:', error);
        this.errorMessage = 'Errore durante la registrazione. Riprova più tardi.';
      }
    );
  }
}
