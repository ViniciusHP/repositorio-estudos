package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDescontos {

    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getQuantidadeItens() > 5) {
            return new BigDecimal("0.1").multiply(orcamento.getValor());
        }

        if(new BigDecimal("500").compareTo(orcamento.getValor()) < 0) {
            return new BigDecimal("0.1").multiply(orcamento.getValor());
        }

        return BigDecimal.ZERO;
    }
}
