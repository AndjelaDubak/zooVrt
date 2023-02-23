import { Obavestenje } from "./obavestenje";

export class Korisnik{
    ime: string;
    prezime: string;
    korIme: string;
    lozinka: string;
    telefon: string;
    email: string;
    adresa: string;
    tip: string;
    obavestenja: Obavestenje[];
}