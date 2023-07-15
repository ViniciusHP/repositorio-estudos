package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;

public class OrcamentoProxy extends Orcamento{

    private BigDecimal valor;
    private final Orcamento orcamento;

    public OrcamentoProxy(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor() {
        if(valor == null) {
            valor = orcamento.getValor();
        }

        return valor;
    }

    @Override
    public void aplicarDescontoExtra() {
        orcamento.aplicarDescontoExtra();
    }

    @Override
    public void aprovar() {
        orcamento.aprovar();
    }

    @Override
    public void reprovar() {
        orcamento.reprovar();
    }

    @Override
    public void finalizar() {
        orcamento.finalizar();
    }

    @Override
    public int getQuantidadeItens() {
        return orcamento.getQuantidadeItens();
    }

    @Override
    public SituacaoOrcamento getSituacao() {
        return orcamento.getSituacao();
    }

    @Override
    public void setSituacao(SituacaoOrcamento situacao) {
        orcamento.setSituacao(situacao);
    }

    @Override
    public boolean isFinalizado() {
        return orcamento.isFinalizado();
    }

    @Override
    public void adicionarItem(Orcavel item) {
        orcamento.adicionarItem(item);
    }
}
