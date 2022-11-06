package br.com.alura.loja.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
public class Categoria {

    @EmbeddedId
    private CategoriaId categoriaId;

    public Categoria(String nome) {
        this.categoriaId = new CategoriaId(nome, "GERAL");
    }

    public String getNome() {
        return this.categoriaId.getNome();
    }

    public void setNome(String nome) {
        this.categoriaId.setNome(nome);
    }
}
