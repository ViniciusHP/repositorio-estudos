package br.com.vhp.modelo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;

    @Override
    public String toString() {
        return String.format("ID: %d;%nNOME: %s;%nDESCRIÇÃO: %s;", id, nome, descricao);
    }
}
