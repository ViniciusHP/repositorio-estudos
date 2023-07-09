package com.vhp.pedido;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeraPedido {

    String cliente;
    BigDecimal valorOrcamento;
    int quantidadeItens;
}
