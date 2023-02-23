import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paketi',
  templateUrl: './paketi.component.html',
  styleUrls: ['./paketi.component.css']
})
export class PaketiComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  kupiInd() {
    sessionStorage.setItem('kupovina', JSON.stringify('individualna'));
    this.router.navigate(['/kupi']);
  }

  kupiPar() {
    sessionStorage.setItem('kupovina', JSON.stringify('par'));
    this.router.navigate(['/kupi']);
  }

  kupiPorodica() {
    sessionStorage.setItem('kupovina', JSON.stringify('porodica'));
    this.router.navigate(['/kupi']);
  }

  kupiKompanija() {
    sessionStorage.setItem('kupovina', JSON.stringify('kompanija'));
    this.router.navigate(['/kupi']);
  }

}
