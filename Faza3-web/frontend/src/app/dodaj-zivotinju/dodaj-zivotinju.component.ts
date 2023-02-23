import { Component, OnInit } from '@angular/core';
import { Zivotinja } from '../models/zivotinja';

@Component({
  selector: 'app-dodaj-zivotinju',
  templateUrl: './dodaj-zivotinju.component.html',
  styleUrls: ['./dodaj-zivotinju.component.css']
})
export class DodajZivotinjuComponent implements OnInit {

  constructor() { 

  }

  ngOnInit(): void {
    this.uspesno = false;
    this.naziv = '';
    this.opis = '';
    this.poruka = '';
    this.zivotinje = JSON.parse(localStorage.getItem('zivotinje'));
  }

  zivotinje: Zivotinja[];
  naziv: string;
  opis: string;
  poruka: string;
  height: number;
  width: number;
  uspesno: boolean;

  fileChangeEvent(fileInput: any) {
    const Img = new Image();

    const filesToUpload = (fileInput.target.files);
    Img.src = URL.createObjectURL(filesToUpload[0]);
  }


  dodaj(Image) {
    this.poruka = '';
    this.uspesno = false;
    let format = Image.value.split(".");
    let slika = Image.value.split("\\");

    if(this.naziv == '' || this.opis == '') {
      this.poruka = 'Popunite sva polja!';
      return false;
    }
    if(Image.value == '') {
      this.poruka = 'Unesite sliku!';
      return false;
    }
    if(format[1] != 'png' && format[1] != 'jpg') {
      this.poruka = 'Dozvoljen format slike je jpg ili png!';
      return false;
    }

    let z = new Zivotinja();
    z.naziv = this.naziv;
    z.opis = this.opis;
    z.slika = slika[2];
    z.komentari = [];
    
    this.zivotinje.push(z);
    localStorage.setItem('zivotinje', JSON.stringify(this.zivotinje));

    this.uspesno = true;

    return true;
  }

}
