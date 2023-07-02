package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoParaOrcamentoComValorMaiorQueQuinhentos extends Desconto{
    public DescontoParaOrcamentoComValorMaiorQueQuinhentos(Desconto proximo) {
        super(proximo);
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return new BigDecimal("500").compareTo(orcamento.getValor()) < 0;
    }

    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return new BigDecimal("0.05").multiply(orcamento.getValor());
    }
}
