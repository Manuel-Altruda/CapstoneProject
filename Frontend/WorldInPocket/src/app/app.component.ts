import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
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
}
