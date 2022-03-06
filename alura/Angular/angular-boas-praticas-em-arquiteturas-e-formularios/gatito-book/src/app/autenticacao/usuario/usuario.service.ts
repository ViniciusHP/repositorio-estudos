import { Injectable } from '@angular/core';
import jwtDecode from 'jwt-decode';
import { BehaviorSubject, Observable } from 'rxjs';
import { TokenService } from '../token.service';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  // Tipo de Subject que contém estado interno. Quando é feita uma inscrição, ele envia o último item
  private usuarioSubject = new BehaviorSubject<Usuario>({});

  constructor(private tokenService: TokenService) {
    if (this.tokenService.possuiToken()) {
      this.decodificaJWT();
    }
  }

  retornaUsuario(): Observable<Usuario> {
    return this.usuarioSubject.asObservable();
  }

  salvaToken(token: string) {
    this.tokenService.salvaToken(token);
    this.decodificaJWT();
  }

  logout(): void {
    this.tokenService.excluiToken();
    this.decodificaJWT();
  }

  estaLogado(): boolean {
    return this.tokenService.possuiToken();
  }

  private decodificaJWT(): void {
    const token = this.tokenService.retornaToken();
    const usuario = jwtDecode<Usuario>(token);
    this.usuarioSubject.next(usuario);
  }
}
