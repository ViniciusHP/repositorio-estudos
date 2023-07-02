package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto{
    public DescontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
        super(proximo);
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQuantidadeItens() > 5;
    }

    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return new BigDecimal("0.1").multiply(orcamento.getValor());
    }
}
