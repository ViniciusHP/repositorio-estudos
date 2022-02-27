import { Component, Input, OnInit } from '@angular/core';
import { Transferencia } from '../models/transferencia.model';
import { TransferenciaService } from '../services/transferencia.service';

@Component({
  selector: 'extrato',
  templateUrl: './extrato.component.html',
  styleUrls: ['./extrato.component.scss'],
})
export class ExtratoComponent implements OnInit {
  @Input() transferencias: Transferencia[];

  constructor(private service: TransferenciaService) {}

  ngOnInit(): void {
    this.service.todas().subscribe((transferencias: Transferencia[]) => {
      this.transferencias = transferencias;
    });
  }
}
