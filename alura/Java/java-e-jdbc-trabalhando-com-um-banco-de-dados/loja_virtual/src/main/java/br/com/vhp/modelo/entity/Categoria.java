package br.com.vhp.modelo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Categoria {

    private Integer id;
    private String nome;

    @Override
    public String toString() {
        return String.format("CATEGORIA( ID = %d; NOME = %s )", id, nome);
    }
}
