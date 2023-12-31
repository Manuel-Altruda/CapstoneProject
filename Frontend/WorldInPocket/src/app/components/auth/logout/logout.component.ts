import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss'],
})
export class LogoutComponent {
  constructor(private router: Router, private svc: AuthService) {}

  isLoggingOut: boolean = false;

  ngOnInit() {
    this.isLoggingOut = true;

    this.svc.logout();
    setTimeout(() => {
      this.isLoggingOut = false;
      this.router.navigate(['']);
    }, 3000);
  }
}
