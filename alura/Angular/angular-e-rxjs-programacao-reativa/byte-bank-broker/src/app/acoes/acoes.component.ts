import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AcoesService } from './acoes.service';
import { Acoes } from './modelo/acoes';

@Component({
  selector: 'app-acoes',
  templateUrl: './acoes.component.html',
  styleUrls: ['./acoes.component.css'],
})
export class AcoesComponent implements OnInit {
  acoesInput = new FormControl();
  acoes$ = this.acoesInput.valueChanges.pipe(tap(console.log))

  constructor(private acoesService: AcoesService) {}

  ngOnInit(): void {
    //this.acoes$ = this.acoesService.getAcoes(); 
  }
}
