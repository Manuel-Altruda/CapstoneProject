import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, catchError, map, tap } from 'rxjs';
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

  constructor(private http:HttpClient, private router:Router,  private jwtHelper: JwtHelperService){
    this.storageUser=JSON.parse(localStorage.getItem("user")!);
    if(this.storageUser) this.loggedUser.next(this.storageUser);
  }

  register(user:IregisterUser) : Observable<any> {
    return this.http.post(environment.registrazione, user);
  }

  /* login(user:IloginUser) : Observable <IUser> {
    return this.http.post<IUser>(environment.login, user).pipe(
      map((u: IUser) => {
        this.loggedUser.next(u);
        localStorage.setItem("user", JSON.stringify(u));
        this.router.navigate(["/dashboard"]);
        return u; // Restituisci l'oggetto IUser
      }),
      catchError((error: any) => {
        console.error('Errore durante il login:', error);
        throw error;
      })
    );
  } */
  login(user: IloginUser): Observable<IUser> {
    return this.http.post<IUser>(environment.login, user).pipe(
      map((u: IUser) => {
        const token = u.accessToken;
        if (token && !this.jwtHelper.isTokenExpired(token)) {
          this.loggedUser.next(u);
          localStorage.setItem("user", JSON.stringify(u));
          this.router.navigate(["/dashboard"]);
          return u;
        } else {
          console.error('Token JWT non valido o scaduto');
          throw new Error('Token JWT non valido o scaduto');
        }
      }),
      catchError((error: any) => {
        console.error('Errore durante il login:', error);
        throw error;
      })
    );
  }

  isUserLoggedIn(): boolean {
    return !!this.loggedUser.value;
  }

  logout() {
    this.loggedUser.next(null);
    localStorage.removeItem("user");
    localStorage.removeItem("token");
    this.router.navigate(["/"]);
  }


}
