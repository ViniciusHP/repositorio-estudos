import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { merge, Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, switchMap, tap } from 'rxjs/operators';
import { AcoesService } from './acoes.service';
import { Acoes } from './modelo/acoes';

const ESPERA_DIGITACAO = 300;

@Component({
  selector: 'app-acoes',
  templateUrl: './acoes.component.html',
  styleUrls: ['./acoes.component.css'],
})
export class AcoesComponent implements OnInit {
  acoesInput = new FormControl();
  todasAcoes$: Observable<Acoes>;
  filtroPeloInput$: Observable<Acoes>;
  acoes$: Observable<Acoes>;

  constructor(private acoesService: AcoesService) {}

  ngOnInit(): void {
    this.todasAcoes$ = this.acoesService
      .getAcoes()
      .pipe(tap(() => console.log('Fluxo inicial')));

    this.filtroPeloInput$ = this.acoesInput.valueChanges.pipe(
      tap(() => console.log('Fluxo filtro')),
      debounceTime(ESPERA_DIGITACAO),
      filter(
        (valorDigitado) => valorDigitado.length >= 3 || !valorDigitado.length
      ),
      distinctUntilChanged(),
      switchMap((valorDigitado) => this.acoesService.getAcoes(valorDigitado))
    );

    this.acoes$ = merge(this.todasAcoes$, this.filtroPeloInput$);
  }
}
