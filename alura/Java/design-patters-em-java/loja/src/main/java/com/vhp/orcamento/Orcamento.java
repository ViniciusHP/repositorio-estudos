package com.vhp.orcamento;


import com.vhp.orcamento.situacao.EmAnalise;
import com.vhp.orcamento.situacao.SituacaoOrcamento;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orcamento {

    BigDecimal valor;
    int quantidadeItens;
    SituacaoOrcamento situacao = new EmAnalise();

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
    }

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
