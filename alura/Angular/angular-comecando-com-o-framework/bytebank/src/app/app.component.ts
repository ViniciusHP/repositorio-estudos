import { Component } from '@angular/core';
import { Transferencia } from './nova-transferencia/nova-transferencia.component';
import { TransferenciaService } from './services/transferencia.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  constructor(private service: TransferenciaService) {}

  transferir(transferencia: Transferencia) {
    this.service.adicionar(transferencia);
  }
}
