package br.com.alura.escola;

import br.com.alura.escola.aplicacao.indicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.indicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosMemoria;


public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);
        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosMemoria());
        matricular.executa(dto);

        System.out.println("Matriculado");
    }
}
