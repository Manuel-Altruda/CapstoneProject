import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'worldInPocket';

  showModal = false;

  registerUser(registrationData: any) {
    // Invia i dati di registrazione al server o esegui altre operazioni necessarie
    console.log('Dati di registrazione:', registrationData);

    // Chiudi il modale
    this.showModal = false;
  }

  isHomePage: boolean = false;

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.isHomePage = event.url === '/'; // Imposta isHomePage in base all'URL
      }
    });
  }
}
