import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaketiComponent } from './paketi.component';

describe('PaketiComponent', () => {
  let component: PaketiComponent;
  let fixture: ComponentFixture<PaketiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaketiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaketiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
