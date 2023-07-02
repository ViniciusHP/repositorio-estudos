package com.vhp.descontos;

import com.vhp.orcamento.Orcamento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Desconto {
    Desconto proximo;

    public abstract BigDecimal calcular(Orcamento orcamento);
}
