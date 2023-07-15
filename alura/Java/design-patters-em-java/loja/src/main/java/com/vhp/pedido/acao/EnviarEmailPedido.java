package com.vhp.pedido.acao;

import com.vhp.pedido.AcaoAposGerarPedido;
import com.vhp.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando email com dados do pedido!");
    }
}
