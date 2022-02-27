import { Component } from '@angular/core';
import { Transferencia } from './nova-transferencia/nova-transferencia.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'bytebank';

  transferir(transferencia: Transferencia) {
    console.log(transferencia);
  }
}
