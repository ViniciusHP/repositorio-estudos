package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// Bloqueia que o Spring substitua o banco de dados pelo banco em memória
@ActiveProfiles("test")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("Deveria carregar curso ao buscar pelo nome")
    @Test
    public void deveriaCarregarCursoAoBuscarPeloSeuNome() {
        String nomeCurso = "HTML 5";
        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programação");
        em.persist(html5);

        Optional<Curso> cursoOptional = repository.findByNome(nomeCurso);

        Assertions.assertTrue(cursoOptional.isPresent());
        Assertions.assertEquals(nomeCurso, cursoOptional.get().getNome());
    }

    @DisplayName("Não deveria carregar curso que não foi cadastrado ao buscar pelo nome")
    @Test
    public void naoDeveriaCarregarCursoQueNaoFoiCadastradoAoBuscarPeloNome() {
        String nomeCurso = "JPA";
        Optional<Curso> cursoOptional = repository.findByNome(nomeCurso);

        Assertions.assertFalse(cursoOptional.isPresent());
    }
}
