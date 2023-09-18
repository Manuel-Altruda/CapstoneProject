import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login-modal',
  templateUrl: './login-modal.component.html',
  styleUrls: ['./login-modal.component.scss']
})
export class LoginModalComponent {
  fG!:FormGroup;
  userLoggedIn = false;
  errorMessage: string = '';
  loginData : any = {};
  ngOnInit(): void {
    this.fG=new FormGroup({
      username: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required)
    });
  }

  constructor(private authService: AuthService, private router: Router) {}

  @Output() loginSuccess = new EventEmitter<void>();

  loginUser(fG : NgForm) {

    this.authService.login(fG.value).subscribe(
      (response: any) => {
        this.router.navigate(['/dashboard']);
        this.loginSuccess.emit();
        this.userLoggedIn = true;
      },
      (error: any) => {
        console.error('Errore durante il login:', error);
        this.errorMessage = 'Credenziali non valide. Riprova.';
      }
    );
  }

  @Output() loginClicked = new EventEmitter<any>();



  login(fG : NgForm) {
    console.log('Funzione login chiamata');
    // Invia i dati di accesso al componente padre
    this.loginClicked.emit(this.loginData);
  }

}
