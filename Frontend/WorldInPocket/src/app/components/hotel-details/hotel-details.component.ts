import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.scss']
})
export class HotelDetailsComponent implements OnInit {
  hotelId: any;
  selectedHotel: any;

  constructor(private route: ActivatedRoute, private hotelService: HotelService) { }

  ngOnInit(): void {
    // Ottieni l'ID dell'hotel dalla route
    this.route.params.subscribe(params => {
      this.hotelId = params['id'];
      // Ora puoi utilizzare this.hotelId per ottenere le informazioni dell'hotel dal tuo servizio o file JSON
      this.hotelService.getHotelById(this.hotelId).subscribe((data: any) => {
        this.selectedHotel = data; // Assumi che la tua chiamata al servizio restituisca i dettagli dell'hotel
      });
    });
  }

  loadHotelDetails() {
    // Ora puoi utilizzare this.hotelId per caricare i dettagli dell'hotel
    this.hotelService.getHotelDetails(this.hotelId).subscribe((data: any) => {
      this.selectedHotel = data; // Assumi che la tua chiamata al servizio restituisca i dettagli dell'hotel
    });
  }
}

