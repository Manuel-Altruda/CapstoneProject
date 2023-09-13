import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
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

  errorMessage: string = '';

  fG!:FormGroup;

  ngOnInit(): void {
    this.fG=new FormGroup({
      username: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required)
    });
  }

  constructor(private authService: AuthService, private router: Router) {}


  login(fG : NgForm) {
    console.log(fG.value);
    this.authService.login(fG.value).subscribe(
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
