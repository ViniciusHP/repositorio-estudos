package br.com.alura.escola.academico.academico;

import br.com.alura.escola.academico.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.academico.dominio.PublicadorDeEventos;
import br.com.alura.escola.academico.academico.dominio.aluno.ouvintes.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {
	
	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";

		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());

		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
		matricular.executa(
				new MatricularAlunoDto(nome, 
						cpf, 
						email));
	}

}
