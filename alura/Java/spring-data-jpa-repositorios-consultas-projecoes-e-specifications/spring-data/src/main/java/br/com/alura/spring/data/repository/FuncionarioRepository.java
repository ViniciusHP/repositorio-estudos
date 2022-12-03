package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long> {

    List<Funcionario> findByNomeLike(String nome);

    @Query("""
        SELECT f
        FROM Funcionario f
        WHERE f.nome = :nome
            AND f.salario >= :salario
            AND f.dataContratacao = :dataContratacao
    """)
    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, BigDecimal salario, LocalDate dataContratacao);
    List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, BigDecimal salario, LocalDate dataContratacao);

    @Query(value = """
        SELECT *
        FROM funcionario f
        WHERE f.data_contratacao >= :data
    """, nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);

    @Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
    List<Funcionario> findByCargoPelaDescricao(String descricao);
    List<Funcionario> findByCargoDescricao(String descricao);

    @Query("SELECT f FROM Funcionario f JOIN f.unidadesDeTrabalho u WHERE u.descricao = :descricao")
    List<Funcionario> findByUnidadesDeTrabalhoPelaDescricao(String descricao);
    List<Funcionario> findByUnidadesDeTrabalho_Descricao(String descricao);

}
