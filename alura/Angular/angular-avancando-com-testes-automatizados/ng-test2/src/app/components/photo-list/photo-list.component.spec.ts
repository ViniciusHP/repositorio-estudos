import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PhotoListComponent } from './photo-list.component';
import { PhotoListModule } from './photo-list.module';

describe(PhotoListComponent.name, () => {

  let component: PhotoListComponent = null;
  let fixture: ComponentFixture<PhotoListComponent> = null;

  beforeEach(async() => {
    await TestBed.configureTestingModule({
      imports: [PhotoListModule, HttpClientModule]
    }).compileComponents();

    fixture = TestBed.createComponent(PhotoListComponent);
    component = fixture.componentInstance;
  })

  it('SHOULD create component', () => {
    expect(component).toBeTruthy();
  })
})