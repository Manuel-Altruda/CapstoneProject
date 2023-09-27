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

getToken(): string | null {
  return this.token || localStorage.getItem('accessToken');
}

removeToken(): void {
  localStorage.removeItem('accessToken');
}


}
