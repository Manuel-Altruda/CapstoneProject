import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { HotelService } from 'src/app/service/hotel.service';
import { iHotel } from '../../interfaces/iHotel';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.scss']
})
export class HotelDetailsComponent implements OnInit {
  selectedHotel : any;
  isLoading = true;
  isError = false;

  constructor(
    private route: ActivatedRoute,
    private hotelService: HotelService,
  ) {}


  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const hotelId = params.get('id');
      if (hotelId) {
        this.hotelService.getHotelById(hotelId).subscribe((data: any) => {
          this.selectedHotel = data;
          this.isLoading = false;
        });
      }
    });
  }











/* loadHotelDetails() {
    this.hotelService.getHotelById(this.hotelId).subscribe(
      (data: iHotel) => {
        this.selectedHotel = data;
        this.isLoading = false;
      },
      (error) => {
        console.error('Errore durante il recupero dei dettagli dell\'hotel:', error);
        this.isError = true;
        this.isLoading = false;
      }
    );
  }
*/


 /* ngOnInit(): void {
    this.route.params.subscribe(params => {
      const hotelId = params['hotelId'];
      console.log(hotelId);
      const token = 'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtYW5AZW1haWwuY29tIiwicm9sZSI6W3siaWQiOjIsInJvbGVOYW1lIjoiUk9MRV9VU0VSIn1dLCJpYXQiOjE2OTQ4MDAyMzMsImV4cCI6MTY5NTY2NDIzM30.wHEJIxZnYMr6CjGBEgQBpHloWDQRrZw12Mo2947fwR-SlV1dsu2RHWkQqEFRvt_b'; // Sostituisci con il tuo token effettivo
      this.hotelService.getHotelDetails(hotelId, token).subscribe(data => {
        this.selectedHotel = data; // Memorizza i dettagli dell'hotel nell'oggetto hotelDetails
      });
    });
  }




  goToHotelList(hotelId: string) {
    this.router.navigate(['/hotels']);
  }

  sendHotelDataToBackend() {
    if (!this.selectedHotel) {
      console.error('Nessun hotel selezionato per l\'invio al backend.');
      return;
    }

    // Invia i dati al backend
    this.http.post('/api/hotels/hotelJson', [this.selectedHotel]).subscribe(
      (response) => {
        console.log('Dati inviati con successo al backend', response);
      },
      (error) => {
        console.error('Errore nell\'invio dei dati al backend', error);
      }
    );
  }*/
}

