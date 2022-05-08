import { Component, ViewChild } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Photo } from './interfaces/photo';
import { PhotoBoardComponent } from './photo-board.component';
import { PhotoBoardModule } from './photo-board.module';

/** Forma não tão usual */

function buildPhotoList(): Photo[] {
  const photos: Photo[] = [];

  for (let i = 0; i < 8; i++) {
    photos.push({
      id: i,
      url: '',
      description: '',
    });
  }

  return photos;
}

describe(PhotoBoardComponent.name, () => {
  let fixture: ComponentFixture<PhotoBoardTestComponent> = null;
  let component: PhotoBoardTestComponent = null;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PhotoBoardTestComponent],
      imports: [PhotoBoardModule],
    }).compileComponents();

    fixture = TestBed.createComponent(PhotoBoardTestComponent);
    component = fixture.componentInstance;
  });

  it(`SHOULD display rows and columns
  WHEN (@Input photos) has value`, () => {
    component.photos = buildPhotoList();
    fixture.detectChanges();

    expect(component.board.rows.length)
      .withContext(`Number of rows`)
      .toBe(2);
    expect(component.board.rows[0].length)
      .withContext(`Number of columns from the first row`)
      .toBe(4);
    expect(component.board.rows[1].length)
      .withContext(`Number of columns from the second row`)
      .toBe(4);
  });
});

@Component({
  template: `
  <app-photo-board
    [photos]="photos">
  </app-photo-board>
  `
})
class PhotoBoardTestComponent {
  @ViewChild(PhotoBoardComponent) public board: PhotoBoardComponent;
  public photos: Photo[] = [];
}
