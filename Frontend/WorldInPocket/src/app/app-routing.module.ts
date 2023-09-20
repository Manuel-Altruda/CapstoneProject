import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/auth/register/register.component';
import { LoginComponent } from './components/auth/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LogoutComponent } from './components/auth/logout/logout.component';
import { AuthGuard } from './auth.guard';
import { HotelDetailsComponent } from './components/hotel-details/hotel-details.component';
import { AppComponent } from './app.component';
import { HomeHeaderComponent } from './components/home-header/home-header.component';
import { PrenotazioneHotelComponent } from './components/prenotazione-hotel/prenotazione-hotel.component';
import { PagamentoComponent } from './components/pagamento/pagamento.component';

const routes: Routes = [


  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: 'hotel-details/:id', component: HotelDetailsComponent },
  { path: 'prenotazione-hotel', component: PrenotazioneHotelComponent},
  { path: 'pagamento', component: PagamentoComponent },
  { path: 'logout', component: LogoutComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
