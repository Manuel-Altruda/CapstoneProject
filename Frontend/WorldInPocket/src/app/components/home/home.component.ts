import { HttpClient } from '@angular/common/http';
import { HotelService } from './../../service/hotel.service';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { PhotoService } from 'src/app/service/photo.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [PhotoService]
})
export class HomeComponent implements OnInit{
  images: any[] | undefined;
  flights: any[] = [];
  hotels: any[] = [];
  valueChange: EventEmitter<any> = new EventEmitter<any>();
  responsiveOptions: any[] | undefined;

  constructor(private hotelService: HotelService, private http: HttpClient) {}

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

}
