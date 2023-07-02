package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto{
    public DescontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getQuantidadeItens() > 5) {
            return new BigDecimal("0.1").multiply(orcamento.getValor());
        }

        return proximo.calcular(orcamento);
    }
}
