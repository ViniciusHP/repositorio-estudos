package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @DisplayName("Deveria carregar curso ao buscar pelo nome")
    @Test
    public void deveriaCarregarCursoAoBuscarPeloSeuNome() {
        String nomeCurso = "HTML 5";
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
