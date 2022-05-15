import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { PhotoBoardService } from 'src/app/shared/components/photo-board/services/photo-board.service';
import { buildPhotoList } from 'src/app/shared/components/photo-board/test/build-photo-list';
import { PhotoListComponent } from './photo-list.component';
import { PhotoListModule } from './photo-list.module';

describe(PhotoListComponent.name, () => {
  let component: PhotoListComponent = null;
  let fixture: ComponentFixture<PhotoListComponent> = null;
  let service: PhotoBoardService = null;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PhotoListModule, HttpClientModule],
    }).compileComponents();

    fixture = TestBed.createComponent(PhotoListComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(PhotoBoardService);
  });

  it('SHOULD create component', () => {
    expect(component).toBeTruthy();
  });

  it(`(D) SHOULD display board
  WHEN data arrives`, () => {
    fixture.detectChanges();
    const photos = buildPhotoList();
    spyOn(service, 'getPhotos')
      .and.returnValue(of(photos));
  });
});
