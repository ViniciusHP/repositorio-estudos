package br.com.alura.escola.aplicacao.indicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        // MOCK
        RepositorioDeAlunosMemoria repositorio = new RepositorioDeAlunosMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano",
                "123.456.789-00",
                "fulano@gmail.com");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));
        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpf());
        assertEquals("fulano@gmail.com", encontrado.getEmail());
    }
}
