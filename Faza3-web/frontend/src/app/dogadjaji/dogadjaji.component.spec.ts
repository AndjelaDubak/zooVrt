import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DogadjajiComponent } from './dogadjaji.component';

describe('DogadjajiComponent', () => {
  let component: DogadjajiComponent;
  let fixture: ComponentFixture<DogadjajiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DogadjajiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DogadjajiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
