import { HttpClient } from '@angular/common/http';
import { HotelService } from './../../service/hotel.service';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { PhotoService } from 'src/app/service/photo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [PhotoService]
})
export class HomeComponent implements OnInit{
  selectedHotel: any;
  images: any[] | undefined;
  flights: any[] = [];
  hotels: any[] = [];
  valueChange: EventEmitter<any> = new EventEmitter<any>();
  responsiveOptions: any[] | undefined;
  hotelId: any;

  constructor(private hotelService: HotelService, private http: HttpClient, private router: Router) {}

  ngOnInit() : void {

    this.http.get<any>('./assets/hotel.json').subscribe(data => {

      this.hotels = data.hotels;
    });

    this.responsiveOptions = [
      {
          breakpoint: '1199px',
          numVisible: 1,
          numScroll: 1
      },
      {
          breakpoint: '991px',
          numVisible: 2,
          numScroll: 1
      },
      {
          breakpoint: '767px',
          numVisible: 1,
          numScroll: 1
      }
  ];
}

  getThumbnailUrl(thumbnail: string): string {
    return `assets/thumbnails/${thumbnail}`;
  }

  showHotelDetails(hotel: string) {
    this.selectedHotel = hotel;
    this.router.navigate(['/hotel', this.hotelId]);
  }

}
