import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from '../models/korisnik';
import { Zivotinja } from '../models/zivotinja';

@Component({
  selector: 'app-konkretna-zivotinja',
  templateUrl: './konkretna-zivotinja.component.html',
  styleUrls: ['./konkretna-zivotinja.component.css']
})
export class KonkretnaZivotinjaComponent implements OnInit {

  constructor(private router: Router) {
    this.komentar = '';
    this.zivotinje = [];
   }

  ngOnInit(): void {
    this.nemaKomentara = false;
    this.zivotinje = JSON.parse(localStorage.getItem('zivotinje'));
    this.zivotinja = JSON.parse(sessionStorage.getItem('konkretnaZivotinja'));
    this.korisnik = JSON.parse(sessionStorage.getItem('ulogovan'));
    if(this.zivotinja.komentari.length == 0) {
      this.nemaKomentara = true;
    }
  }

  zivotinja: Zivotinja;
  komentar: string;
  zivotinje: Zivotinja[];
  korisnik: Korisnik;
  nemaKomentara: boolean;

  dodajKom() {
    if(this.komentar != '') {
      let kom = this.korisnik.korIme + ': ' + this.komentar;
      for(let i=0; i<this.zivotinje.length; i++) {
        if(this.zivotinje[i].naziv == this.zivotinja.naziv) {
          if(this.zivotinje[i].komentari[0] != "" ) {
            this.zivotinje[i].komentari.push(kom);
            this.zivotinja.komentari.push(kom);
          }
          else {
            this.zivotinje[i].komentari[0] = kom; 
            this.zivotinja.komentari[0] = kom;
          }
         
        }
      }
      sessionStorage.setItem('konkretnaZivotinja', JSON.stringify(this.zivotinja));
      localStorage.setItem('zivotinje', JSON.stringify(this.zivotinje));
      this.komentar = '';
    }
    
  }

}
