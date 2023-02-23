import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Zivotinja } from '../models/zivotinja';

@Component({
  selector: 'app-zivotinje',
  templateUrl: './zivotinje.component.html',
  styleUrls: ['./zivotinje.component.css']
})
export class ZivotinjeComponent implements OnInit {

  constructor(private router: Router) { 
    this.zivotinje = []; 
  }

  ngOnInit(): void {
    this.zivotinje = JSON.parse(localStorage.getItem('zivotinje'));
    this.page = 1;
    this.pageSize = 5;
  }

  zivotinje: Zivotinja[];
  page: number;
  pageSize: number;

  konkretnaZivotinja(zivotinja) {
    sessionStorage.setItem('konkretnaZivotinja', JSON.stringify(zivotinja));
    this.router.navigate(['/zivotinja']);
  }

}
