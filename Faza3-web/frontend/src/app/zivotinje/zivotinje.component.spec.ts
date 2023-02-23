import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZivotinjeComponent } from './zivotinje.component';

describe('ZivotinjeComponent', () => {
  let component: ZivotinjeComponent;
  let fixture: ComponentFixture<ZivotinjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZivotinjeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZivotinjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
