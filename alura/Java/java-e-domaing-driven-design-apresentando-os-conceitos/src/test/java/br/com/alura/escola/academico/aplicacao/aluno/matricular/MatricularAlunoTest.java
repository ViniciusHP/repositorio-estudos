package br.com.alura.escola.academico.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.alura.escola.academico.academico.dominio.PublicadorDeEventos;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.academico.dominio.aluno.CPF;
import br.com.alura.escola.academico.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		// MOCK -> Mockito
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		MatricularAluno useCase = new MatricularAluno(repositorio, publicador);
		
		MatricularAlunoDto dados = new MatricularAlunoDto(
				"Fulano", 
				"123.456.789-00", 
				"fulano@email.com");
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCPF(
				new CPF("123.456.789-00"));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.456.789-00", encontrado.getNumeroCpf());
		assertEquals("fulano@email.com", encontrado.getEmail());
	}

}
