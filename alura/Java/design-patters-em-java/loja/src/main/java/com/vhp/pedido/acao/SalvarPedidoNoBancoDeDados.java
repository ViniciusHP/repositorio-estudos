package com.vhp.pedido.acao;

import com.vhp.pedido.AcaoAposGerarPedido;
import com.vhp.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Salvando pedido no banco de dados!");
    }
}
