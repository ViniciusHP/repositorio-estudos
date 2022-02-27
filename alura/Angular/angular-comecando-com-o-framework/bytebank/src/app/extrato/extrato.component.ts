import { Component, Input } from '@angular/core';
import { Transferencia } from '../nova-transferencia/nova-transferencia.component';

@Component({
  selector: 'extrato',
  templateUrl: './extrato.component.html',
  styleUrls: ['./extrato.component.scss'],
})
export class ExtratoComponent {
  @Input() transferencias: Transferencia[];
}
