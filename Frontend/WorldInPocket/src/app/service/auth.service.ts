import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
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
  user: string = "${user}";

  constructor(private http:HttpClient, private router:Router){
    this.storageUser=JSON.parse(localStorage.getItem("user")!);
    if(this.storageUser) this.loggedUser.next(this.storageUser);
  }

  register(user:IregisterUser) : Observable<any> {
    return this.http.post(environment.registrazione, user);
  }

  login(user:IloginUser) : Observable <IUser> {
    return this.http.post<IUser>(environment.login, user).pipe(
      map((u: IUser) => {
        this.loggedUser.next(u);
        localStorage.setItem("user", JSON.stringify(u));
        this.router.navigate(["/dashboard"]);
        return u; // Restituisci l'oggetto IUser
      })
    );
  }

  isUserLoggedIn(): boolean {
    return !!this.loggedUser.value;
  }

  logout(){
    this.loggedUser.next(null);
    localStorage.removeItem("user");
    this.router.navigate(["/"]);
  }


}
