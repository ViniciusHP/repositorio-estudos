import { Injectable } from '@angular/core';
import { Transferencia } from '../nova-transferencia/nova-transferencia.component';

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  private _listaTransferencias: Transferencia[];

  constructor() {
    this._listaTransferencias = [];
  }

  get transferencias() {
    return this._listaTransferencias;
  }

  adicionar(transferencia: Transferencia) {
    this._tratar(transferencia)
    this._listaTransferencias.push(transferencia);
  }

  private _tratar(transferencia: Transferencia) {
    transferencia.data = new Date;
  }
}
