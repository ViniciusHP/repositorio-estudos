package com.vhp.orcamento.situacao;

import com.vhp.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento{
    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
