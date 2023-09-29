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
import { VoloComponent } from './components/volo/volo.component';
import { VoloDetailsComponent } from './components/volo-details/volo-details.component';
import { PaySuccessComponent } from './components/pagamento/pay-success/pay-success.component';
import { PayErrorComponent } from './components/pagamento/pay-error/pay-error.component';
import { SectionDashboardComponent } from './components/section-dashboard/section-dashboard.component';

const routes: Routes = [


  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'section-dashboard', component: SectionDashboardComponent, canActivate: [AuthGuard] },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: 'hotel-details/:id', component: HotelDetailsComponent },
  { path: 'volo', component: VoloComponent },
  { path: 'volo-details/:id', component: VoloDetailsComponent },
  { path: 'prenotazione-hotel', component: PrenotazioneHotelComponent},
  { path: 'pagamento', component: PagamentoComponent },
  { path: 'pagamento/:orderID', component: PagamentoComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'pay-success', component: PaySuccessComponent },
  { path: 'pay-error', component: PayErrorComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
