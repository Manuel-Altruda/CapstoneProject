import { AfterViewInit, Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-home-header',
  templateUrl: './home-header.component.html',
  styleUrls: ['./home-header.component.scss']
})
export class HomeHeaderComponent implements OnInit, AfterViewInit {
  @ViewChild('sectionBeaches') sectionBeaches!: ElementRef;
  @ViewChild('sectionCivilization') sectionCivilization!: ElementRef;
  @ViewChild('sectionPlaces') sectionPlaces!: ElementRef;

  constructor(private renderer: Renderer2) { }
  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
    this.addScrollAnimation(this.sectionBeaches.nativeElement);
    this.addScrollAnimation(this.sectionCivilization.nativeElement);
    this.addScrollAnimation(this.sectionPlaces.nativeElement);
  }

  private addScrollAnimation(element: HTMLElement): void {
    const scrollHandler = () => {
      const rect = element.getBoundingClientRect();
      const windowHeight = window.innerHeight || document.documentElement.clientHeight;

      if (rect.top < windowHeight * 0.4) {
        this.renderer.addClass(element.querySelector('.text'), 'fadeIn'); // Aggiunge la classe CSS fadeIn
        window.removeEventListener('scroll', scrollHandler); // Rimuove l'ascoltatore dopo l'animazione
      }
    };

    window.addEventListener('scroll', scrollHandler);
    scrollHandler(); // Controlla l'animazione all'inizio
  }
}
