import { Korisnik } from "./korisnik";

export class Dogadjaj {
    naziv: string;
    opis: string;
    datum: string;
    brLajkova: number;
    lajkovali: Korisnik[];
    slika: String;
}