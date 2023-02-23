import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../models/korisnik';
import { Obavestenje } from '../models/obavestenje';
import { Zahtev } from '../models/zahtev';

@Component({
  selector: 'app-zahtevi',
  templateUrl: './zahtevi.component.html',
  styleUrls: ['./zahtevi.component.css']
})
export class ZahteviComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.nemaZahteva = false;
    this.zahtevi = JSON.parse(localStorage.getItem('zahtevi'));
    this.korisnici = JSON.parse(localStorage.getItem('korisnici'));
    if(this.zahtevi == null || this.zahtevi.length == 0) {
      this.nemaZahteva = true;
    }
  }

  zahtevi: Zahtev[];
  korisnici: Korisnik[];
  nemaZahteva: boolean;

  prihvati(zahtev) {
    for(let i=0; i<this.zahtevi.length; i++) {
      if(this.zahtevi[i].korisnik.korIme == zahtev.korisnik.korIme && this.zahtevi[i].tip == zahtev.tip && this.zahtevi[i].br == zahtev.br) {
        this.zahtevi.splice(i, 1);
      }
    }
    let o = new Obavestenje();
    if(zahtev.tip == 'individualna') {
      o.opis = "Vaš zahtev za kupovinu individualne ulaznice je prihvaćen.";
    }
    if(zahtev.tip == 'par') {
      o.opis = "Vaš zahtev za kupovinu ulaznice za parove je prihvaćen.";
    }
    if(zahtev.tip == 'porodica') {
      o.opis = "Vaš zahtev za kupovinu ulaznice za porodicu je prihvaćen.";
    }
    if(zahtev.tip == 'kompanija') {
      o.opis = "Vaš zahtev za kupovinu ulaznice za kompanije je prihvaćen.";
    }
    let datum = new Date();
    let mesec = datum.getMonth() + 1;
    o.datum = datum.getDate().toString() + '.' + mesec.toString() + '.' + datum.getFullYear().toString() + '.';
    o.vreme = datum.getHours().toString() + ':' + datum.getMinutes();

    for(let i=0; i<this.korisnici.length; i++) {
      if(zahtev.korisnik.korIme == this.korisnici[i].korIme) {
        this.korisnici[i].obavestenja.push(o);
      }
    }

    localStorage.setItem('zahtevi', JSON.stringify(this.zahtevi));
    localStorage.setItem('korisnici', JSON.stringify(this.korisnici));
  }

  odbij(zahtev) {
    for(let i=0; i<this.zahtevi.length; i++) {
      if(this.zahtevi[i].korisnik.korIme == zahtev.korisnik.korIme && this.zahtevi[i].tip == zahtev.tip && this.zahtevi[i].br == zahtev.br) {
        this.zahtevi.splice(i, 1);
      }
    }

    let o = new Obavestenje();
    if(zahtev.tip == 'individualna') {
      o.opis = "Vaš zahtev za kupovinu individualne ulaznice je odbijen.";
    }
    if(zahtev.tip == 'par') {
      o.opis = "Vaš zahtev za kupovinu ulaznice za parove je odbijen.";
    }
    if(zahtev.tip == 'porodica') {
      o.opis = "Vaš zahtev za kupovinu ulaznice za porodicu je odbijen.";
    }
    if(zahtev.tip == 'kompanija') {
      o.opis = "Vaš zahtev za kupovinu ulaznice za kompanije je odbijen.";
    }
    let datum = new Date();
    let mesec = datum.getMonth() + 1;
    o.datum = datum.getDate().toString() + '.' + mesec.toString() + '.' + datum.getFullYear().toString() + '.';
    o.vreme = datum.getHours().toString() + ':' + datum.getMinutes();

    for(let i=0; i<this.korisnici.length; i++) {
      if(zahtev.korisnik.korIme == this.korisnici[i].korIme) {
        this.korisnici[i].obavestenja.push(o);
      }
    }

    localStorage.setItem('zahtevi', JSON.stringify(this.zahtevi));
    localStorage.setItem('korisnici', JSON.stringify(this.korisnici));
  }

}
