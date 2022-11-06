package br.com.alura.loja.modelo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CategoriaId implements Serializable {
    private static final long serialVersionUID = 4442799748649225519L;

    private String nome;
    private String tipo;
}
