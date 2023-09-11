import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { IUser } from '../interfaces/Iuser';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private token: string | null = null;
  private user: IUser | null = null;
  private headers:HttpHeaders | undefined;

constructor(private authSvc: AuthService, private http:HttpClient) {
  authSvc.isUserLogged.subscribe(user => {
    this.user = user
    this.headers=new HttpHeaders({
      'Authorization': `Bearer ${this.user?.accessToken}`
    });
  });

}

getUser(): any {
  return this.user;
}

// Recupera il token JWT dal localStorage
getToken(): string | null {
  return this.token || localStorage.getItem('accessToken');
}

// Rimuove il token JWT dal localStorage dopo il logout
removeToken(): void {
  localStorage.removeItem('accessToken');
}

/* getPage(nPagina:number, size:number){
  return this.http.get<Page>(environment.clienti+"?page="+nPagina+"&size="+size, {headers: this.headers});
}
*/

}
