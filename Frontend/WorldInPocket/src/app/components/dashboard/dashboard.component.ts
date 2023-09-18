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
  hotelId: string | any;
  selectedHotel: any[] = [];
  images: any[] | undefined;
  flights: any[] = [];
  hotels: any[] = [];
  valueChange: EventEmitter<any> = new EventEmitter<any>();
  responsiveOptions: any[] | undefined;


  constructor(private hotelService: HotelService, private router: Router, private http: HttpClient) {}

  ngOnInit() : void {

    this.hotelService.getAllHotels().subscribe((data: any[]) => {
      this.hotels = data;
    });

    /* this.hotelService.getHotelById(this.hotelId).subscribe((data: any[]) => {
      this.hotels = data;
    }); */

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

  goToHotelDetails(hotelId: string) {
    this.router.navigate(['/hotel-details', hotelId]);
  }

  viewHotelDetails(hotelId: string): void {
    this.router.navigate(['/hotel-details', hotelId]);
  }



}
