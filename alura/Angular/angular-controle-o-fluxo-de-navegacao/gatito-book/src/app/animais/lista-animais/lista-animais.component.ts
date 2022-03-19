import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Animais } from '../animal';

@Component({
  selector: 'app-lista-animais',
  templateUrl: './lista-animais.component.html',
  styleUrls: ['./lista-animais.component.css'],
})
export class ListaAnimaisComponent implements OnInit {
  animais!: Animais;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      console.log(this.activatedRoute.snapshot.data);

      this.animais = this.activatedRoute.snapshot.data['animais'];
    })
  }
}
