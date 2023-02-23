import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../models/korisnik';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.korisnici = JSON.parse(localStorage.getItem('korisnici'));
    this.korisnik = JSON.parse(sessionStorage.getItem('ulogovan'));
    this.korIme = this.korisnik.korIme;
    this.ime = this.korisnik.ime;
    this.prezime = this.korisnik.prezime;
    this.telefon = this.korisnik.telefon;
    this.adresa = this.korisnik.adresa;
    this.email = this.korisnik.email;
    this.staraLoz = '';
    this.potvrdaLoz = '';
    this.novaLoz = '';
    this.poruka = '';
    this.porukaLoz = '';
    this.uspesno = false;
    this.uspesnoLoz = false;
  }

  korisnik: Korisnik;
  korisnici: Korisnik[];
  ime: string;
  prezime: string;
  korIme: string;
  telefon: string;
  adresa: string;
  email: string;
  staraLoz: string;
  novaLoz: string;
  potvrdaLoz: string;
  poruka: string;
  porukaLoz: string;
  uspesno: boolean;
  uspesnoLoz: boolean;

  izmeniInf() {
    this.poruka = '';
    this.uspesno = false;
    if(this.korIme == this.korisnik.korIme && this.ime == this.korisnik.ime && this.prezime == this.korisnik.prezime && this.email == this.korisnik.email && this.adresa == this.korisnik.adresa && this.telefon == this.korisnik.telefon) {
      this.poruka = 'Nijedna informacija nije izmenjena.';
      return false;
    }
    this.poruka = '';
    for(let i=0;i<this.korisnici.length;i++) {
      if(this.korIme != this.korisnik.korIme) {
        if(this.korisnici[i].korIme == this.korIme) {
          this.poruka = 'Korisničko ime zazueto!';
          return false;
        }
      }
    }
    if(this.ime.length<3 && this.ime != '') {
      this.poruka = 'Ime mora sadržati bar 3 slova!';
      return false;
    }
    if(this.prezime.length<3 && this.prezime != '') {
      this.poruka = 'Prezime mora sadržati bar 3 slova!';
      return false;
    }
    if(/^\d\d\d-\d\d\d-\d{3,4}$/.test(this.telefon) == false && this.telefon != '') {
      this.poruka = 'Unesite telefon u formatu: xxx-xxx-xxx(x)';
      return false;
    }
    if(/\w@\w/.test(this.email) == false && this.email != '') {
      this.poruka = 'Unesite validan mejl sa @!';
      return false;
    }
    if(this.ime == '') {
      this.ime = this.korisnik.ime;
    }
    if(this.prezime == '') {
      this.prezime = this.korisnik.prezime;
    }
    if(this.korIme == '') {
      this.korIme = this.korisnik.korIme;
    }
    if(this.telefon == '') {
      this.telefon = this.korisnik.telefon;
    }
    if(this.adresa == '') {
      this.adresa = this.korisnik.adresa;
    }
    if(this.email == '') {
      this.email = this.korisnik.email;
    }

    let staroKorIme = this.korisnik.korIme;

    this.korisnik.korIme = this.korIme;
    this.korisnik.ime = this.ime;
    this.korisnik.prezime = this.prezime;
    this.korisnik.telefon = this.telefon;
    this.korisnik.adresa = this.adresa;
    this.korisnik.email = this.email;

    for(let i=0; i<this.korisnici.length; i++) {
      if(this.korisnici[i].korIme == staroKorIme) {
        this.korisnici[i].korIme = this.korIme;
        this.korisnici[i].ime = this.ime;
        this.korisnici[i].prezime = this.prezime;
        this.korisnici[i].telefon = this.telefon;
        this.korisnici[i].adresa = this.adresa;
        this.korisnici[i].email = this.email;
      }
    }
 
    sessionStorage.setItem('ulogovan', JSON.stringify(this.korisnik));
    localStorage.setItem('korisnici', JSON.stringify(this.korisnici));
    
    this.uspesno = true;

    return true;
  }

  promeniLoz() {
    this.porukaLoz = '';
    this.uspesnoLoz = false;
    if(this.staraLoz == '') {
      this.porukaLoz = 'Unesite staru lozinku!';
      return false;
    }
    if(this.staraLoz != this.korisnik.lozinka) {
      this.porukaLoz = 'Stara lozinka pogrešna!';
      return false;
    }
    if(this.novaLoz == '') {
      this.porukaLoz = 'Unesite novu lozinku!';
      return false;
    }
    if(this.novaLoz.length < 8) {
      this.porukaLoz = 'Lozinka mora sadržati bar 8 karaktera!';
      return false;
    }
    if(/[a-z]/.test(this.novaLoz) == false) {
      this.porukaLoz = 'Lozinka mora počinjati slovom!';
      return false;
    }
    if(/[A-Z]/.test(this.novaLoz) == false) {
      this.porukaLoz = 'Lozinka mora sadržati bar 1 veliko slovo!';
      return false;
    }
    if(/[\d{+}]/.test(this.novaLoz) == false) {
      this.porukaLoz = 'Lozinka mora sadržati bar 1 broj!';
      return false;
    }
    if(/[^a-zA-Z\d]/.test(this.novaLoz) == false ) {
      this.porukaLoz = 'Lozinka mora sadržati bar 1 specijalan karakter!'
      return false;
    }
    if(this.potvrdaLoz == '') {
      this.porukaLoz = 'Unesite potvrdu lozinke!';
      return false;
    }
    if(this.novaLoz != this.potvrdaLoz) {
      this.porukaLoz = 'Pogrešna potvrda lozinke!';
      return false;
    }

    this.korisnik.lozinka = this.novaLoz;
    for(let i=0; i<this.korisnici.length; i++) {
      if(this.korisnici[i].korIme == this.korisnik.korIme) {
        this.korisnici[i].lozinka = this.novaLoz;
      }
    }

    sessionStorage.setItem('ulogovan', JSON.stringify(this.korisnik));
    localStorage.setItem('korisnici', JSON.stringify(this.korisnici));
    
    this.uspesnoLoz = true;

    return true;
  }

}
