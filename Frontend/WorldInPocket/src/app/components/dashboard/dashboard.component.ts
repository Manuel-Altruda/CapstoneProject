import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  selectedHotel: any;
  images: any[] | undefined;
  flights: any[] = [];
  hotels: any[] = [];
  valueChange: EventEmitter<any> = new EventEmitter<any>();
  responsiveOptions: any[] | undefined;

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

  showHotelDetails(hotelId: string) {
    this.router.navigate(['/hotel', hotelId]);
  }


}
