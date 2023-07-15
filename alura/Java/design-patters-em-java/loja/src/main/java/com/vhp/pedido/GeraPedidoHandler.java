package com.vhp.pedido;

import com.vhp.orcamento.Orcamento;
import com.vhp.pedido.acao.EnviarEmailPedido;
import com.vhp.pedido.acao.SalvarPedidoNoBancoDeDados;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeraPedidoHandler {

    List<AcaoAposGerarPedido> acoes;

    public void executa(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
        final Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));
    }
}
