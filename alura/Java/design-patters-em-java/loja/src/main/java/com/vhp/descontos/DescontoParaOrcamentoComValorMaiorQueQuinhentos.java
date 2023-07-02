package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoParaOrcamentoComValorMaiorQueQuinhentos extends Desconto{
    public DescontoParaOrcamentoComValorMaiorQueQuinhentos(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if(new BigDecimal("500").compareTo(orcamento.getValor()) < 0) {
            return new BigDecimal("0.05").multiply(orcamento.getValor());
        }

        return proximo.calcular(orcamento);
    }
}
