package com.vhp.pedido;

import com.vhp.orcamento.Orcamento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeraPedido {

    String cliente;
    BigDecimal valorOrcamento;
    int quantidadeItens;

    public void executa() {
        Orcamento orcamento = new Orcamento(valorOrcamento, quantidadeItens);
        Pedido pedido = new Pedido(cliente, LocalDateTime.now(), orcamento);

        System.out.println("Salvar pedido no Banco de Dados");
        System.out.println("Enviar email com dados do novo pedido");
    }
}
