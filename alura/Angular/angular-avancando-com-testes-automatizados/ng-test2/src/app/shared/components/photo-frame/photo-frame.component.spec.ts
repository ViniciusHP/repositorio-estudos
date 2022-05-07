import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PhotoFrameComponent } from './photo-frame.component';
import { PhotoFrameModule } from './photo-frame.module';

describe(PhotoFrameComponent.name, () => {
  let fixture: ComponentFixture<PhotoFrameComponent> = null;
  let component: PhotoFrameComponent = null;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PhotoFrameModule],
    }).compileComponents();

    fixture = TestBed.createComponent(PhotoFrameComponent);
    component = fixture.componentInstance;
  });

  it(`SHOULD create component`, () => {
    expect(component).toBeTruthy();
  });

  it(`#${PhotoFrameComponent.prototype.like.name}
  SHOULD trigger (@Output liked) once
  WHEN called multiple times within debounce time`, () => {
    fixture.detectChanges();
    let times = 0;
    component.liked.subscribe(() => times++);
    component.like();
    component.like();

    expect(times).toBe(1);
  });
});
