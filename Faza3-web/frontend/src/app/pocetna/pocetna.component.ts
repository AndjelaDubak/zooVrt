import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dogadjaj } from '../models/dogadjaj';
import { Korisnik } from '../models/korisnik';
import { Zahtev } from '../models/zahtev';
import { Zivotinja } from '../models/zivotinja';

@Component({
  selector: 'app-pocetna',
  templateUrl: './pocetna.component.html',
  styleUrls: ['./pocetna.component.css']
})
export class PocetnaComponent implements OnInit {

  constructor(private router: Router) {
    this.zivotinje = [];
    this.zahtevi = [];
    this.dogadjaji = [];
  }

  ngOnInit(): void {
    this.korisnici = JSON.parse(localStorage.getItem('korisnici'));

    let zivotinje = JSON.parse(localStorage.getItem('zivotinje'));
    if(zivotinje == null) {
      let z = new Zivotinja();
      z.naziv = 'Tigar';
      z.opis = 'Tigar je sisar iz porodice mačaka i jedan od četiri vrste „velikih mačaka“ roda pantera. On je vrhunski predator i najveća živa mačka na svetu. U brojnim istorijskim mitovima istočnjačkih zemalja tigar je kralj svih zveri. Bengalski tigar je najpoznatija podvrsta i sačinjava približno 80% ukupne populacije tigrova.';
      z.slika = 'tigar.jpg';
      z.komentari = ['marko: Opasna životinja', 'nikola: Beautiful!'];

      let z1 = new Zivotinja();
      z1.naziv = 'Merkat';
      z1.opis = 'Merkat je vrsta malih sisara iz reda zveri i porodice mungosa. Ova vrsta je jedini živi član roda Suricata. Merkati žive u svim delovima pustinje Kalahari u Bocvani, u većem delu Namibijske pustinje u Namibiji i u jugozapadnim delovima Angole, kao i u Južnoj Africi. Žive u grupama koje se nazivaju klanovi.';
      z1.slika = 'merkat.jpg';
      z1.komentari = ['marko: Preslatki su!'];

      let z2 = new Zivotinja();
      z2.naziv = 'Lisica';
      z2.opis = 'Riđa lisica je najpoznatija od svih vrsta lisica. Takođe je najrasprostranjenija ne samo vrsta lisica, već i od svih ostalih kopnenih mesojeda. Kao što ime govori, njeno krzno je najčešće riđo-braon boje. Postoji oko 40 podvrsta.';
      z2.slika = 'lija.jpg';
      z2.komentari = ['petar: Iako su lukave, slatke su.'];

      let z3 = new Zivotinja();
      z3.naziv = 'Majmun';
      z3.opis = 'Majmun je naziv za pojedine životinjske vrste iz sisarskog reda primata. Red primata možemo deliti na dve grupe: u prvu grupu bi se mogli ubrajati svi polumajmuni, a u drugu pravi majmuni, čovekoliki majmuni i ljudi.';
      z3.slika = 'majmuni.jpg';
      z3.komentari = ['mia: Divni su.'];
      
      let z4 = new Zivotinja();
      z4.naziv = 'Slon';
      z4.opis = 'Slonovi su velike životinje iz familije Elephantidae iz reda Proboscidea. Tri vrste su trenutno priznate: afrički slon, afrički šumski slon, i azijski slon. Stanište slonova se prostire širom podsaharijske Afrike, južne Azije, i jugoistočne Azije.';
      z4.slika = 'slon.jpg';
      z4.komentari = ['marija: Njihova surla je zanimljiva.'];

      let z5 = new Zivotinja();
      z5.naziv = 'Zebra';
      z5.opis = 'Zebra je životinja koja pripada porodici Equidae (porodici konja) i koja živi u centralnoj i južnoj Africi. Zebra živi u manjim krdima u savani. Jedna porodica se obično sastoji od pastuva, nekoliko kobila i njihovih ždrebadi. Grupa porodica čini krdo. Danju pase travu i odmara se u senci nekog drveta.';
      z5.slika = 'zebra.jpg';
      z5.komentari = ['milos: Zebra print je najbolji!.'];

      let z6 = new Zivotinja();
      z6.naziv = 'Lav';
      z6.opis = 'Lav je veliki sisar iz porodice mačaka i jedna od „velikih mačaka“ roda pantera. Mužjak lava, lako prepoznatljiv po svojoj grivi, u proseku teži između 180-255 kilograma. Ženke su manje i teže od 110-155 kilograma.';
      z6.slika = 'lav.jpg';
      z6.komentari = ['kaca: Lav je kralj životinja.', 'andjela: Volim mačke, kao i lava.'];

      let z7 = new Zivotinja();
      z7.naziv = 'Pingvin';
      z7.opis = 'Pingvini su monotipični red vodenih, neletećih ptica, koje žive uglavnom na južnoj hemisferi. Jedini član reda je istoimena porodica Spheniscidae, koja obuhvata šest rodova sa 17 ili 20 vrsta, u zavisnosti od autora.';
      z7.slika = 'pingvin.jpg';
      z7.komentari = ['andjela: Najsladji su.'];

      let z8 = new Zivotinja();
      z8.naziv = 'Koala';
      z8.opis = 'Koala je australijski torbarski biljojed i jedini živi predstavnik istoimene porodice Phascolarctidae. Naseljava obalska područja istočne i južne Australije, od okoline Adelejda do južnih delova rta Jork.';
      z8.slika = 'koala.jpg';
      z8.komentari = ['mira: Ovo je ugrožena vrsta.', 'vlado: Treba ih čuvati. Divni su.'];

      let z9 = new Zivotinja();
      z9.naziv = 'Foka';
      z9.opis = 'Foka ili prava foka je rod perajara koji pripada porodici pravih foka. Takođe, foka je naziv za nekoliko drugih rodova i vrsta vodenih sisara iz grupe perajara, koji spadaju u porodice: pravih foka i ušatih foka.';
      z9.slika = 'foka.jpg';
      z9.komentari = ['nikola: Foke su nekada živele na kopnu.'];

      this.zivotinje.push(z);
      this.zivotinje.push(z1);
      this.zivotinje.push(z2);
      this.zivotinje.push(z3);
      this.zivotinje.push(z4);
      this.zivotinje.push(z5);
      this.zivotinje.push(z6);
      this.zivotinje.push(z7);
      this.zivotinje.push(z8);
      this.zivotinje.push(z9);

      localStorage.setItem('zivotinje', JSON.stringify(this.zivotinje));
    }

    let zahtevi = JSON.parse(localStorage.getItem('zahtevi'));
    if(zahtevi == null) {
      let zahtev = new Zahtev();
      zahtev.cena = '1100';
      zahtev.korisnik = this.korisnici[0];
      zahtev.promoKod = '';
      zahtev.tip = 'individualna';   
      zahtev.br = '2';  
  
      this.zahtevi.push(zahtev);

      let zahtev1 = new Zahtev();
      zahtev1.cena = '1800';
      zahtev1.korisnik = this.korisnici[0];
      zahtev1.promoKod = '553';
      zahtev1.tip = 'par';   
      zahtev1.br = '3';  
  
      this.zahtevi.push(zahtev1);
      localStorage.setItem('zahtevi', JSON.stringify(this.zahtevi));
    }
    else {
      this.zahtevi = JSON.parse(localStorage.getItem('zahtevi'));
    }

  
    let dogadjaji = JSON.parse(localStorage.getItem('dogadjaji'));
    if(dogadjaji == null) {
      let dog = new Dogadjaj();
      dog.naziv = 'Nova godina u zoo vrtu Pandica';
      dog.brLajkova = 10;
      dog.opis = 'Ove godine organizujemo proslavu Nove godine. Dođi i zabavi se sa nama.';
      dog.datum = '31.12.2022.';
      dog.lajkovali = [this.korisnici[0], this.korisnici[1]];
      dog.slika = 'nova.jpg';
      
      let dog1 = new Dogadjaj();
      dog1.naziv = 'Dan žena u zoo vrtu Pandica';
      dog1.brLajkova = 15;
      dog1.opis = 'Svim damama poklanjamo besplatan ulaz u zoo Pandica!';
      dog1.datum = '08.03.2023.';
      dog1.lajkovali = [this.korisnici[1]];
      dog1.slika = 'lale.jpg';
  
      let dog2 = new Dogadjaj();
      dog2.naziv = 'Druženje sa kengurima';
      dog2.brLajkova = 22;
      dog2.opis = 'Kengur, čovekov najbolji prijatelj! Dođi i ti da se družiš sa kengurima.';
      dog2.datum = '20.02.2023.';
      dog2.lajkovali = [this.korisnici[1]];
      dog2.slika = 'kenguri.jpg';
  
      let dog3 = new Dogadjaj();
      dog3.naziv = 'Seminar';
      dog3.brLajkova = 18;
      dog3.opis = 'Organizovan je seminar o dobrobiti životinja. Program traje od 24.01.2023. do 28.01.2023.';
      dog3.datum = '24.01.2023.';
      dog3.lajkovali = [this.korisnici[1]];
      dog3.slika = 'seminar.jpg';
  
      let dog4 = new Dogadjaj();
      dog4.naziv = 'Zajedno hranimo foke';
      dog4.brLajkova = 18;
      dog4.opis = 'Dođite da zajedno hranimo zanimljive foke!';
      dog4.datum = '15.04.2023.';
      dog4.lajkovali = [this.korisnici[1]];
      dog4.slika = 'hrana.jpg';
  
      this.dogadjaji.push(dog,dog1,dog2,dog3,dog4);
      localStorage.setItem('dogadjaji', JSON.stringify(this.dogadjaji));
    }

  }

  zivotinje: Zivotinja[];
  zahtevi: Zahtev[];
  korisnici: Korisnik[];
  dogadjaji: Dogadjaj[];

  sveZivotinje() {
    this.router.navigate(['/zivotinje']);
  }  

}
