package br.com.vhp.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;

    @Override
    public String toString() {
        return String.format("ID: %d; NOME: %s; DESCRIÇÃO: %s", id, nome, descricao);
    }
}
