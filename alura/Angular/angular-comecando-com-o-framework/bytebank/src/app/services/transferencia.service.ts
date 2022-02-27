import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transferencia } from '../models/transferencia.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class TransferenciaService {
  private _listaTransferencias: Transferencia[];
  private _url: string;

  constructor(private httpClient: HttpClient) {
    this._url = `${environment.urlApi}/transferencias`;
    this._listaTransferencias = [];
  }

  get transferencias() {
    return this._listaTransferencias;
  }

  todas(): Observable<Transferencia[]> {
    return this.httpClient.get<Transferencia[]>(this._url);
  }

  adicionar(transferencia: Transferencia): Observable<Transferencia> {
    this._tratar(transferencia);

    return this.httpClient.post<Transferencia>(this._url, transferencia);
  }

  private _tratar(transferencia: Transferencia) {
    transferencia.data = new Date().toISOString();
  }
}
