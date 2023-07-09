package com.vhp.pedido;

import com.vhp.orcamento.Orcamento;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pedido {

    String cliente;
    LocalDateTime data;
    Orcamento orcamento;
}
