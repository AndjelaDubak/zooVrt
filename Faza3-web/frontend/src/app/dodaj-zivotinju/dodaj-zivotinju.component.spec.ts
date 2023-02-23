import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajZivotinjuComponent } from './dodaj-zivotinju.component';

describe('DodajZivotinjuComponent', () => {
  let component: DodajZivotinjuComponent;
  let fixture: ComponentFixture<DodajZivotinjuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodajZivotinjuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DodajZivotinjuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
