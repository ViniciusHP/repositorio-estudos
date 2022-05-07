import { Component } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActionDirective } from './action.directive';
import { ActionModule } from './action.module';

describe(ActionDirective.name, () => {
  let fixture: ComponentFixture<ActionDirectiveTestComponent> = null;
  let component: ActionDirectiveTestComponent = null;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ActionDirectiveTestComponent],
      imports: [ActionModule],
    }).compileComponents();

    fixture = TestBed.createComponent(ActionDirectiveTestComponent);
    component = fixture.componentInstance;
  });

  it(`(D) (@Output appAction) SHOULD emit event with payload
  WHEN ENTER key is pressed`, () => {
    const divEl: HTMLElement = fixture.nativeElement.querySelector('.dummy-component');
    const event = new KeyboardEvent('keyup', {key: 'Enter'});
    divEl.dispatchEvent(event);

    expect(component.hasEvent()).toBeTrue();
  })
});

@Component({
  template: `<div class="dummy-component" (appAction)="actionHandler($event)"></div>`,
})
class ActionDirectiveTestComponent {
  private event: Event = null;

  public actionHandler(event: Event): void {
    this.event = event;
  }

  public hasEvent(): boolean {
    return !!this.event;
  }
}
