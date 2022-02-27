import { Component } from '@angular/core';

@Component({
  selector: 'nova-transferencia',
  templateUrl: './nova-transferencia.component.html',
  styleUrls: ['./nova-transferencia.component.scss'],
})
export class NovaTransferenciaComponente {

  valor: number;
  destino: number;

  transferir() {
    console.log('Nova transferência');
    console.log(`Valor: ${this.valor}`);
    console.log(`Destino: ${this.destino}`);
  }
}
