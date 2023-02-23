import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dogadjaj } from '../models/dogadjaj';
import { Korisnik } from '../models/korisnik';

@Component({
  selector: 'app-dogadjaji',
  templateUrl: './dogadjaji.component.html',
  styleUrls: ['./dogadjaji.component.css']
})
export class DogadjajiComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.dogadjaji = JSON.parse(localStorage.getItem('dogadjaji'));
    this.korisnik = JSON.parse(sessionStorage.getItem('ulogovan'));
    this.page = 1;
    this.pageSize = 2;
  }

  dogadjaji: Dogadjaj[];
  page: number;
  pageSize: number;
  korisnik: Korisnik;

  postoji(dog) {
    if (dog.lajkovali.find(e => e.korIme === this.korisnik.korIme)) {
     return true;
    }
    return false;
  }

  lajkuj(dog) {
    for(let i=0; i<this.dogadjaji.length; i++) {
      if(this.dogadjaji[i].naziv == dog.naziv) {
        let broj = this.dogadjaji[i].brLajkova + 1;
        this.dogadjaji[i].brLajkova = broj;
        this.dogadjaji[i].lajkovali.push(this.korisnik);
      }
    }
    localStorage.setItem('dogadjaji', JSON.stringify(this.dogadjaji));
  }

  odlajkuj(dog) {
    for(let i=0; i<this.dogadjaji.length; i++) {
      if(this.dogadjaji[i].naziv == dog.naziv) {
        let broj = this.dogadjaji[i].brLajkova - 1;
        this.dogadjaji[i].brLajkova = broj;
        for(let j=0; j<this.dogadjaji[i].lajkovali.length; j++) {
          if(this.dogadjaji[i].lajkovali[j].korIme == this.korisnik.korIme) {
            console.log('syiezzz');
            this.dogadjaji[i].lajkovali.splice(j,1);
          }
        }
      }
    }
    localStorage.setItem('dogadjaji', JSON.stringify(this.dogadjaji));
  }

}
