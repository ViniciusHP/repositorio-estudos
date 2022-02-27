import { Component, Input, OnInit } from '@angular/core';
import { Transferencia } from '../nova-transferencia/nova-transferencia.component';
import { TransferenciaService } from '../services/transferencia.service';

@Component({
  selector: 'extrato',
  templateUrl: './extrato.component.html',
  styleUrls: ['./extrato.component.scss'],
})
export class ExtratoComponent implements OnInit{
  @Input() transferencias: Transferencia[];

  constructor(private service: TransferenciaService) {}

  ngOnInit(): void {
      this.transferencias = this.service.transferencias;
  }
}
