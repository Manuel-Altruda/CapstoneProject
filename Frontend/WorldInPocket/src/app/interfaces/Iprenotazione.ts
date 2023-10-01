import { IUser } from "./Iuser";

export interface Iprenotazione {
  hotel: string;
  roomType: string;
  user : IUser;
  phone: string,
  street: string,
  streetNumber: number,
  city: string,
  postCode: number,
  country: string,
  arrive: Date,
  depart: Date,
  people: number,
}
