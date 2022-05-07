import { TestBed } from '@angular/core/testing';
import { ActionDirective } from './action.directive';
import { ActionModule } from './action.module';

describe(ActionDirective.name, () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActionModule],
    }).compileComponents();
  });
});
