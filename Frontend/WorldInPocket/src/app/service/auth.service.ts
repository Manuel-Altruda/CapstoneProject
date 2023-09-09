import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, map, tap } from 'rxjs';
import { IauthResponse } from 'src/app/interfaces/IauthResponse';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { IloginUser } from 'src/app/interfaces/IloginUser';
import { IregisterUser } from '../interfaces/IregisterUser';
import { IUser } from '../interfaces/Iuser';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  private loggedUser=new BehaviorSubject<null | IUser>(null);
  isUserLogged=this.loggedUser.asObservable();
  private storageUser:IUser;

  constructor(private http:HttpClient, private router:Router){
    this.storageUser=JSON.parse(localStorage.getItem("user")!);
    if(this.storageUser) this.loggedUser.next(this.storageUser);
  }

  register(user:IregisterUser)
  {
    return this.http.post(environment.registrazione, user);
  }

  login(user:IloginUser){
    this.http.post<IUser>(environment.login, user).subscribe(u=>{
      this.loggedUser.next(u);
      localStorage.setItem("user", JSON.stringify(u));
      this.router.navigate(["/clienti"]);
    });
  }

  logout(){
    this.loggedUser.next(null);
    localStorage.removeItem("user");
    this.router.navigate(["/"]);
  }
}
