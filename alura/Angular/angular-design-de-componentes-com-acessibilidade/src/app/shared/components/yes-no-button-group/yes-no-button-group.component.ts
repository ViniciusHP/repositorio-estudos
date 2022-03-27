import { Component, EventEmitter, forwardRef, Input, OnInit, Output } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

@Component({
  selector: 'app-yes-no-button-group',
  templateUrl: './yes-no-button-group.component.html',
  styleUrls: ['./yes-no-button-group.component.scss'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR, /* Provendo um ControlValueAccessor a partir de um InjectionToken */
      multi: true, /* Durante a aplicação, podem haver vários provedores de ControlValueAccessor */
      useExisting: forwardRef(() => YesNoButtonGroupComponent) /* Classe que provê a implementação do ControlValueAccessor */
      /*
        forwardRef é usado pois no momento que registramos o token, nossa classe ainda não existe. Dessa forma,
        é feito o registro do token, mas o uso da classe só será feita de maneira tardia, quando a classe já estiver disponível
      */
    }
  ]
})
export class YesNoButtonGroupComponent implements OnInit, ControlValueAccessor {
  @Input() public value: string = null;
  @Input() public label = ''
  @Output() public valueChange = new EventEmitter<string>();
  public options = YesNoButtonGroupOptions;
  public onChange = (value: string) => {};
  public onTouched = () => {};

  constructor() {}

  ngOnInit(): void {}

  public writeValue(value: string): void { // Mudança do modelo e necessidade de atualizar a view
    this.value = value;
    this.onChange(this.value);
    this.valueChange.emit(this.value);
  }

  public registerOnChange(fn: (value: string) => void): void {
    this.onChange = fn; // Função recebida do reactive forms module. A partir dela nós notificamos o formulário que houve uma mudança no valor
  }

  public registerOnTouched(fn: () => void): void {
    this.onTouched = fn; // Função recebida do reactive forms module. A partir dela nós notificamos o formulário quando nosso controle foi 'tocado', ou seja, no evento de 'blur'
  }

  public setDisabledState?(isDisabled: boolean): void {
    throw new Error('Method not implemented.');
  }

  public activate(value: string): void {
    this.writeValue(value);
  }
}

enum YesNoButtonGroupOptions {
  YES = 'yes',
  NO = 'no'
}
