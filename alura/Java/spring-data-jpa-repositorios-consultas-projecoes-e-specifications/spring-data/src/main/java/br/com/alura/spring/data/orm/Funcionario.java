package br.com.alura.spring.data.orm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private BigDecimal salario;

    @Column(name = "data_contratacao")
    private LocalDate dataContratacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidades",
    joinColumns = { @JoinColumn(name = "fk_funcionario")},
    inverseJoinColumns = {@JoinColumn(name = "fk_unidade")})
    private List<UnidadeDeTrabalho> unidadesDeTrabalho = new ArrayList<>();

}
