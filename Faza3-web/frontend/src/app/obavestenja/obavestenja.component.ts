import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../models/korisnik';
import { Obavestenje } from '../models/obavestenje';

@Component({
  selector: 'app-obavestenja',
  templateUrl: './obavestenja.component.html',
  styleUrls: ['./obavestenja.component.css']
})
export class ObavestenjaComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.nemaObavestenja = false;
    this.korisnik = JSON.parse(sessionStorage.getItem('ulogovan'));
    if(this.korisnik.obavestenja == null || this.korisnik.obavestenja.length == 0) {
      this.nemaObavestenja = true;
    }
  }

  korisnik: Korisnik;
  nemaObavestenja: boolean;

}
