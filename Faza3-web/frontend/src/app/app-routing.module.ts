import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DodajZivotinjuComponent } from './dodaj-zivotinju/dodaj-zivotinju.component';
import { DogadjajiComponent } from './dogadjaji/dogadjaji.component';
import { IndexComponent } from './index/index.component';
import { KonkretnaZivotinjaComponent } from './konkretna-zivotinja/konkretna-zivotinja.component';
import { KupiComponent } from './kupi/kupi.component';
import { ObavestenjaComponent } from './obavestenja/obavestenja.component';
import { PaketiComponent } from './paketi/paketi.component';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { PrijavaComponent } from './prijava/prijava.component';
import { ProfilComponent } from './profil/profil.component';
import { RegistracijaComponent } from './registracija/registracija.component';
import { ZahteviComponent } from './zahtevi/zahtevi.component';
import { ZivotinjeComponent } from './zivotinje/zivotinje.component';

const routes: Routes = [
  {path:'', component:IndexComponent},
  {path:'prijava', component:PrijavaComponent},
  {path:'registracija', component:RegistracijaComponent},
  {path:'pocetna', component:PocetnaComponent},
  {path:'zivotinje', component:ZivotinjeComponent},
  {path:'zivotinja', component:KonkretnaZivotinjaComponent},
  {path:'paketi', component:PaketiComponent},
  {path:'kupi', component:KupiComponent},
  {path:'dogadjaji', component:DogadjajiComponent},
  {path:'obavestenja', component:ObavestenjaComponent},
  {path:'profil', component:ProfilComponent},
  {path:'zahtevi', component:ZahteviComponent},
  {path:'dodaj', component:DodajZivotinjuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
