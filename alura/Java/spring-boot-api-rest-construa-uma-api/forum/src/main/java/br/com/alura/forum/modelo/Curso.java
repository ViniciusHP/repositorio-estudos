package br.com.alura.forum.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Curso {
    private Long id;
    private String nome;
    private String categoria;
}
