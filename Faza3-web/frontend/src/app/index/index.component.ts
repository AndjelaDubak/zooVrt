import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from '../models/korisnik';
import { Obavestenje } from '../models/obavestenje';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private router: Router) {
    this.korisnici = [];
    this.obavestenja = [];
  }

  ngOnInit(): void {
    let obavestenja = JSON.parse(localStorage.getItem('obavestenja'));
    if(obavestenja == null) {
      let o = new Obavestenje();
      o.opis = 'Vaš zahtev za kupovinu ulaznice za parove je prihvaćen.';
      o.datum = '18.12.2022.';
      o.vreme = '16:32';

      let o1 = new Obavestenje();
      o1.opis = 'Vaš zahtev za kupovinu pojedinačne ulaznice je prihvaćen.';
      o1.datum = '10.05.2021.';
      o1.vreme = '15:54';

      this.obavestenja.push(o, o1);
      localStorage.setItem('obavestenja', JSON.stringify(this.obavestenja));
    }
    else {
      this.obavestenja = JSON.parse(localStorage.getItem('obavestenja'));
    }

    let korisnici = JSON.parse(localStorage.getItem('korisnici'));
    if(korisnici == null) {
      let korisnik = new Korisnik();
      korisnik.ime = 'Petar';
      korisnik.prezime = 'Peric';
      korisnik.korIme = 'pera';
      korisnik.lozinka = 'Petar123.';
      korisnik.telefon = '061-255-899';
      korisnik.adresa = 'Ruzveltova 14';
      korisnik.email = 'pera@gmail.com';
      korisnik.tip = 'posetilac';
      korisnik.obavestenja = [this.obavestenja[0], this.obavestenja[1]];
      this.korisnici.push(korisnik);

      let korisnik1 = new Korisnik();
      korisnik1.ime = 'Nikola';
      korisnik1.prezime = 'Nikolic';
      korisnik1.korIme = 'nikola';
      korisnik1.lozinka = 'Nikola123.';
      korisnik1.telefon = '061-142-0999';
      korisnik1.adresa = 'Knez Mihailova 25';
      korisnik1.email = 'nikola@gmail.com';
      korisnik1.tip = 'zaposleni';
      this.korisnici.push(korisnik1);

      localStorage.setItem('korisnici', JSON.stringify(this.korisnici));
    }
    else {
      this.korisnici = JSON.parse(localStorage.getItem('korisnici'));
    }

  }

  korisnici: Korisnik[];
  obavestenja: Obavestenje[];

  prijava() {
    this.router.navigate(['/prijava']);
  }

  registracija() {
    this.router.navigate(['/registracija']);
  }




}
