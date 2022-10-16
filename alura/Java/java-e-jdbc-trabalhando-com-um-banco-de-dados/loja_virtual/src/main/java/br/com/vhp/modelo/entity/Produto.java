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

    private Integer categoriaId;

    @Override
    public String toString() {
        return String.format("PRODUTO ( ID = %d; NOME = %s; DESCRIÇÃO = %s; CATEGORIA_ID = %d)", id, nome, descricao, categoriaId);
    }
}
