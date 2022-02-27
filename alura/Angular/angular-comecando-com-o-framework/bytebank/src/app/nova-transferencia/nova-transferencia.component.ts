import { Component, EventEmitter, Output } from '@angular/core';
import { Transferencia } from '../models/transferencia.model';

@Component({
  selector: 'nova-transferencia',
  templateUrl: './nova-transferencia.component.html',
  styleUrls: ['./nova-transferencia.component.scss'],
})
export class NovaTransferenciaComponente {
  @Output() aoTransferir = new EventEmitter<any>();

  valor: number;
  destino: number;

  transferir() {
    console.log('Nova transferência');
    const valorEmitir = {
      valor: this.valor,
      destino: this.destino,
    };
    this.aoTransferir.emit(valorEmitir);
    this.limparCampos();
  }

  limparCampos() {
    this.valor = 0
    this.destino = 0
  }
}
