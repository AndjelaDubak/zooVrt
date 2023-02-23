import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from '../models/korisnik';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.korisnici = JSON.parse(localStorage.getItem('korisnici'));
    this.korIme = '';
    this.lozinka = '';
    this.poruka = '';
    this.ime = '';
    this.prezime = '';
    this.telefon = '';
    this.adresa = '';
    this.email = '';
    this.potvrdaLoz = '';
    this.uspesno = false;
  }

  korisnici: Korisnik[];
  ime: string;
  prezime: string;
  korIme: string;
  telefon: string;
  adresa: string;
  email: string;
  lozinka: string;
  potvrdaLoz: string;
  poruka: string;
  uspesno: boolean;

  registracija() {
    this.poruka = '';
    if(this.ime == '' || this.prezime == '' || this.korIme == '' || this.telefon == '' || this.lozinka == '' || this.potvrdaLoz == '' || this.email == '') {
      this.poruka = 'Popunite sva polja!';
      return false;
    }
    for(let i=0;i<this.korisnici.length;i++) {
      if(this.korisnici[i].korIme == this.korIme) {
        this.poruka = 'Korisničko ime zazueto!';
        return false;
      }
    }
    if(this.ime.length<3) {
      this.poruka = 'Ime mora sadržati bar 3 slova!';
      return false;
    }
    if(this.prezime.length<3) {
      this.poruka = 'Prezime mora sadržati bar 3 slova!';
      return false;
    }
    if(/^\d\d\d-\d\d\d-\d{3,4}$/.test(this.telefon) == false) {
      this.poruka = 'Unesite telefon u formatu: xxx-xxx-xxx(x)';
      return false;
    }
    if(this.adresa.length<3) {
      this.poruka = 'Adresa mora sadržati bar 3 slova!';
      return false;
    }
    if(/\w@\w/.test(this.email) == false) {
      this.poruka = 'Unesite validan mejl sa @!';
      return false;
    }
    if(this.lozinka.length < 8) {
      this.poruka = 'Lozinka mora sadržati bar 8 karaktera!';
      return false;
    }
    if(/[a-z]/.test(this.lozinka) == false) {
      this.poruka = 'Lozinka mora počinjati slovom!';
      return false;
    }
    if(/[A-Z]/.test(this.lozinka) == false) {
      this.poruka = 'Lozinka mora sadržati bar 1 veliko slovo!';
      return false;
    }
    if(/[\d{+}]/.test(this.lozinka) == false) {
      this.poruka = 'Lozinka mora sadržati bar 1 broj!';
      return false;
    }
    if(/[^a-zA-Z\d]/.test(this.lozinka) == false ) {
      this.poruka = 'Lozinka mora sadržati bar 1 specijalan karakter!'
      return false;
    }
    if(this.lozinka != this.potvrdaLoz) {
      this.poruka = 'Pogrešna potvrda lozinke!';
      return false;
    }
    let kor = new Korisnik();
    kor.ime = this.ime;
    kor.prezime = this.prezime;
    kor.korIme = this.korIme;
    kor.telefon = this.telefon;
    kor.adresa = this.adresa;
    kor.email = this.email;
    kor.lozinka = this.lozinka;
    kor.tip = 'posetilac';
    kor.obavestenja = [];
    this.korisnici.push(kor);
    this.uspesno = true;
    localStorage.setItem('korisnici', JSON.stringify(this.korisnici));
    
    return true;
  }



}
