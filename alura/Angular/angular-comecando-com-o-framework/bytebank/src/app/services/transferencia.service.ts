import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transferencia } from '../models/transferencia.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class TransferenciaService {
  private _listaTransferencias: Transferencia[];
  private _url = 'http://localhost:3000/transferencias';

  constructor(private httpClient: HttpClient) {
    this._listaTransferencias = [];
  }

  get transferencias() {
    return this._listaTransferencias;
  }

  todas(): Observable<Transferencia[]>{
    return this.httpClient.get<Transferencia[]>(this._url);
  }

  adicionar(transferencia: Transferencia) {
    this._tratar(transferencia);
    this._listaTransferencias.push(transferencia);
  }

  private _tratar(transferencia: Transferencia) {
    transferencia.data = new Date().toString();
  }
}
