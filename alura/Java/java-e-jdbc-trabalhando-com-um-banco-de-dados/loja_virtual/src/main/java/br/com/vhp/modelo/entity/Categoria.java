package br.com.vhp.modelo.entity;

import lombok.*;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode.Exclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Categoria {

    private Integer id;
    private String nome;

    @EqualsAndHashCode.Exclude
    @Default
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    @Override
    public String toString() {
        return String.format("CATEGORIA( ID = %d; NOME = %s )", id, nome);
    }
}
