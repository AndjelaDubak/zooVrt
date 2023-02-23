import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from '../models/korisnik';
import { Zahtev } from '../models/zahtev';

@Component({
  selector: 'app-kupi',
  templateUrl: './kupi.component.html',
  styleUrls: ['./kupi.component.css']
})
export class KupiComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.korisnik = JSON.parse(sessionStorage.getItem('ulogovan'));
    this.zahtevi = JSON.parse(localStorage.getItem('zahtevi'));
    this.brLjudi = '1';
    this.tip = JSON.parse(sessionStorage.getItem('kupovina'));
    this.cena = 0;
    this.promoKod = '';
    if(this.tip == 'individualna') {
      this.naslov = 'Individualna/grupna';
    }
    if(this.tip == 'par') {
      this.brLjudi = '2';
      this.naslov = 'Paket za parove';
    }
    if(this.tip == 'porodica') {
      this.naslov = 'Porodični paket';
    }
    if(this.tip == 'kompanija') {
      this.naslov = 'Paket za kompanije';
    }
    this.kliknuto = false;
  }

  korisnik: Korisnik;
  tip: string;
  brLjudi: string;
  promoKod: string;
  poruka: string;
  cena: number;
  naslov: string;
  kliknuto: boolean;
  zahtevi: Zahtev[];

  onChangeBr() {
    if(this.tip == 'individualna') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 550 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 550;
      }
    }
    if(this.tip == 'par') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 500 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 500;
      }
    }
    if(this.tip == 'porodica') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 400 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 400;
      }
    }
    if(this.tip == 'kompanija') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 450 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 450;
      }
    }
  }

  prikaziCenu() {
    if(this.tip == 'individualna') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 550 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 550;
      }
    }
    if(this.tip == 'par') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 500 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 500;
      }
    }
    if(this.tip == 'porodica') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 400 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 400;
      }
    }
    if(this.tip == 'kompanija') {
      if(this.promoKod != '') {
        this.cena = parseInt(this.brLjudi) * 450 * 0.9;
      }
      else {
        this.cena = parseInt(this.brLjudi) * 450;
      }
    }

    this.kliknuto = true;
  }

  kupi() {
    let z = new Zahtev();
    this.onChangeBr();
    z.cena = this.cena.toString();
    z.korisnik = this.korisnik;
    z.promoKod = this.promoKod;
    z.tip = this.tip;   
    z.br = this.brLjudi;   

    this.zahtevi.push(z);
    localStorage.setItem('zahtevi', JSON.stringify(this.zahtevi));

    this.poruka = 'Vaša kupovina je evidentirana. Sačekajte obaveštenje o potvrdi.';
  }

}
