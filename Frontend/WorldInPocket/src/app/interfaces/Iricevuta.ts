import { PrenotazioneHotelComponent } from "../components/prenotazione-hotel/prenotazione-hotel.component";
import { PrenotazioneService } from "../modelPyP/prenotazione.service";
import { IUser } from "./Iuser";

export interface Iricevuta {
  orderID: string;
  user : IUser;
  prenotazioni:PrenotazioneHotelComponent[],

}
