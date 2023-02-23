import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { PrijavaComponent } from './prijava/prijava.component';
import { RegistracijaComponent } from './registracija/registracija.component';
import { IndexComponent } from './index/index.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { ZivotinjeComponent } from './zivotinje/zivotinje.component';
import { KonkretnaZivotinjaComponent } from './konkretna-zivotinja/konkretna-zivotinja.component';
import { PaketiComponent } from './paketi/paketi.component';
import { KupiComponent } from './kupi/kupi.component';
import { DogadjajiComponent } from './dogadjaji/dogadjaji.component';
import { ObavestenjaComponent } from './obavestenja/obavestenja.component';
import { ProfilComponent } from './profil/profil.component';
import { ZahteviComponent } from './zahtevi/zahtevi.component';
import { DodajZivotinjuComponent } from './dodaj-zivotinju/dodaj-zivotinju.component';

@NgModule({
  declarations: [
    AppComponent,
    PocetnaComponent,
    PrijavaComponent,
    RegistracijaComponent,
    IndexComponent,
    NavbarComponent,
    FooterComponent,
    ZivotinjeComponent,
    KonkretnaZivotinjaComponent,
    PaketiComponent,
    KupiComponent,
    DogadjajiComponent,
    ObavestenjaComponent,
    ProfilComponent,
    ZahteviComponent,
    DodajZivotinjuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
