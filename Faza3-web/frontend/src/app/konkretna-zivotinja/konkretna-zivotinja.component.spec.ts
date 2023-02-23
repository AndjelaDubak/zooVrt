import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KonkretnaZivotinjaComponent } from './konkretna-zivotinja.component';

describe('KonkretnaZivotinjaComponent', () => {
  let component: KonkretnaZivotinjaComponent;
  let fixture: ComponentFixture<KonkretnaZivotinjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KonkretnaZivotinjaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KonkretnaZivotinjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
