package br.com.alura.forum.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class Resposta {
    private Long id;
    private String mensagem;
    private Topico topico;
    private LocalDateTime dataCriacao;
    private Usuario autor;
    private Boolean solucao = false;
}
