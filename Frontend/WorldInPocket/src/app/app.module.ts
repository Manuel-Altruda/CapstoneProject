import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenubarModule } from 'primeng/menubar';
import { DropdownModule } from 'primeng/dropdown';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { RadioButtonModule } from 'primeng/radiobutton';
import { MessagesModule } from 'primeng/messages';
import { PasswordModule } from 'primeng/password';
import { MessageService } from 'primeng/api';
import { FileUploadModule } from 'primeng/fileupload';
import { CarouselModule } from 'primeng/carousel';
import { ToastModule } from 'primeng/toast';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { GalleriaModule } from 'primeng/galleria';
import { InputSwitchModule } from 'primeng/inputswitch';
import { ToolbarModule } from 'primeng/toolbar';
import { CalendarModule } from 'primeng/calendar';
import { CardModule } from 'primeng/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { DividerModule } from 'primeng/divider';
import { TagModule } from 'primeng/tag';
import { MenuModule } from 'primeng/menu';
import { CheckboxModule } from 'primeng/checkbox';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { JWT_OPTIONS, JwtHelperService } from '@auth0/angular-jwt';
import { LoginModalComponent } from './components/login-modal/login-modal.component';
import { RegisterModalComponent } from './components/register-modal/register-modal.component';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './interceptors/token.interceptor';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { HotelDetailsComponent } from './components/hotel-details/hotel-details.component';
import { HomeTravelPackagesComponent } from './components/home-section-packages/home-section-packages.component';
import { HomeTravelTestimonialsComponent } from './components/home-section-testimonials/home-section-testimonials.component';
import { HomeContactComponent } from './components/home-contact/home-contact.component';
import { HomeFooterComponent } from './components/home-footer/home-footer.component';
import { HomeSectionComponent } from './components/home-section/home-section.component';

import { HomeHeaderComponent } from './components/home-header/home-header.component';
import { PrenotazioneHotelComponent } from './components/prenotazione-hotel/prenotazione-hotel.component';
import { PagamentoComponent } from './components/pagamento/pagamento.component';
import { LogoutComponent } from './components/auth/logout/logout.component';
import { VoloComponent } from './components/volo/volo.component';
import { VoloDetailsComponent } from './components/volo-details/volo-details.component';
import { PaySuccessComponent } from './components/pagamento/pay-success/pay-success.component';
import { PayErrorComponent } from './components/pagamento/pay-error/pay-error.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeSectionComponent,
    NavbarComponent,
    LogoutComponent,
    LoginComponent,
    RegisterComponent,
    LoginModalComponent,
    RegisterModalComponent,
    DashboardComponent,
    HotelDetailsComponent,
    PrenotazioneHotelComponent,
    HomeTravelPackagesComponent,
    HomeHeaderComponent,
    HomeTravelPackagesComponent,
    HomeTravelTestimonialsComponent,
    HomeContactComponent,
    HomeFooterComponent,
    PrenotazioneHotelComponent,
    PagamentoComponent,
    VoloComponent,
    VoloDetailsComponent,
    PaySuccessComponent,
    PayErrorComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    DividerModule,
    GalleriaModule,
    InputTextModule,
    CarouselModule,
    ConfirmDialogModule,
    ToolbarModule,
    RadioButtonModule,
    MenuModule,
    TagModule,
    FormsModule,
    CalendarModule,
    CardModule,
    ProgressSpinnerModule,
    PasswordModule,
    MessagesModule,
    DynamicDialogModule,
    ReactiveFormsModule,
    ToastModule,
    InputSwitchModule,
    FileUploadModule,
    MenubarModule,
    DialogModule,
    DropdownModule,
    ButtonModule,
    CheckboxModule,
    AppRoutingModule
  ],
  providers: [
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
    MessageService,
    { provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
