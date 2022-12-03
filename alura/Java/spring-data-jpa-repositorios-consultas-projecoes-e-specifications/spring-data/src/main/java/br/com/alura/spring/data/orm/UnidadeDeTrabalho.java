package br.com.alura.spring.data.orm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidade_trabalho")
@Getter
@Setter
@NoArgsConstructor
public class UnidadeDeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String endereco;

    @ManyToMany(mappedBy = "unidadesDeTrabalho")
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public String toString() {
        return "UnidadeDeTrabalho{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
