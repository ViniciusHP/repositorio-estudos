package br.com.alura.mvc.mudi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Oferta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDate dataDaEntrega;
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;
}
