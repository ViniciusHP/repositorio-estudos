package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;

import java.math.BigDecimal;

public class SemDesconto extends Desconto {
    public SemDesconto() {
        super(null);
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return true;
    }

    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }
}
