package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Desconto {
    Desconto proximo;

    public BigDecimal calcular(Orcamento orcamento) {
        if(deveAplicar(orcamento)) {
            return efetuarCalculo(orcamento);
        }

        return proximo.calcular(orcamento);
    }

    public abstract boolean deveAplicar(Orcamento orcamento);
    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
}
