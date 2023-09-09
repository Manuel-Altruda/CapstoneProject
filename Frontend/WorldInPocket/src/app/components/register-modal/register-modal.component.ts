import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-register-modal',
  templateUrl: './register-modal.component.html',
  styleUrls: ['./register-modal.component.scss']
})
export class RegisterModalComponent implements OnInit {

  fG!:FormGroup;

  constructor(private authSvc:AuthService, private router:Router) { }
  ngOnInit(): void {
    this.fG=new FormGroup({
      name: new FormControl(""),
      cognome: new FormControl(""),
      username: new FormControl("", Validators.required),
      email: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required)
    });
  }

  submit(){
    this.authSvc.register(this.fG.value).subscribe(res=>{
      this.router.navigate(["/login"]);
    });
  }

  registrationData: any = {};

  @Output() registerClicked = new EventEmitter<any>();

  register() {
    // Invia i dati di registrazione al componente padre tramite l'evento
    this.registerClicked.emit(this.registrationData);
  }

}
