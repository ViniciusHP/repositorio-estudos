import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NovaTransferenciaComponente } from './nova-transferencia/nova-transferencia.component';
import { ExtratoComponent } from './extrato/extrato.component';
import { registerLocaleData } from '@angular/common';

import localePt from '@angular/common/locales/pt';
import { HttpClientModule } from '@angular/common/http';

registerLocaleData(localePt, 'pt');

@NgModule({
  declarations: [AppComponent, NovaTransferenciaComponente, ExtratoComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' }, // Configura a localização brasileira
    { provide: DEFAULT_CURRENCY_CODE, useValue: 'BRL' }, // Configura a moeda default
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
