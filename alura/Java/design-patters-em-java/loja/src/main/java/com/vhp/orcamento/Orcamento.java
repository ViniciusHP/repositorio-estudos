package com.vhp.orcamento;


import com.vhp.orcamento.situacao.EmAnalise;
import com.vhp.orcamento.situacao.SituacaoOrcamento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orcamento {

    BigDecimal valor;
    int quantidadeItens;
    SituacaoOrcamento situacao = new EmAnalise();

    public void aplicarDescontoExtra() {
        BigDecimal valorDoDescontoExtra = situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public void aprovar() {
        situacao.aprovar(this);
    }

    public void reprovar() {
        situacao.reprovar(this);
    }

    public void finalizar() {
        situacao.finalizar(this);
    }
}
