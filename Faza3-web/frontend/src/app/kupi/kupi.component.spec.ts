import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KupiComponent } from './kupi.component';

describe('KupiComponent', () => {
  let component: KupiComponent;
  let fixture: ComponentFixture<KupiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KupiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KupiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
