import { IUser } from "./Iuser";
import { iHotel } from "./iHotel";

export interface Iprenotazione {
  hotel:iHotel,
  user:IUser,
  details: {
    name:string,
    email: string,
    phone: string,
    street: string,
    streetNumber: number,
    city: string,
    postCode: number,
    country: string,
    arrive: Date,
    depart: Date,
    people: number,
    bedding:string,
    roomType:string,
    comments:string
  }
}
