import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from '../models/korisnik';

@Component({
  selector: 'app-prijava',
  templateUrl: './prijava.component.html',
  styleUrls: ['./prijava.component.css']
})
export class PrijavaComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.korisnici = JSON.parse(localStorage.getItem('korisnici'));
    this.korIme = '';
    this.lozinka = '';
    this.poruka = '';
  }

  prijava() {
    this.poruka = '';
    let korisnik;
    if(this.korIme=='' && this.lozinka=='') {
      this.poruka = "Popunite sva polja!";
    }
    else if (this.korIme==''){
      this.poruka = "Unesite korisničko ime!";
    }
    else if(this.lozinka=='') {
      this.poruka = "Unesite lozinku!";
    }
    else {
      for(let i = 0; i < this.korisnici.length; i++) {
        if(this.korisnici[i].korIme == this.korIme) korisnik = this.korisnici[i];
      }
      if(korisnik) {
        if(korisnik.lozinka == this.lozinka) {
          sessionStorage.setItem('ulogovan',JSON.stringify(korisnik));
          this.router.navigate(['/pocetna']);
        }
        else {
          this.poruka = 'Pogrešna lozinka!';
        }
      }
      else {
        this.poruka = "Ne postoji korisnik!";
      }
    }
  

  }

  korisnici: Korisnik[];
  korIme: String;
  lozinka: String;
  poruka: String;


}
