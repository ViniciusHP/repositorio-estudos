package br.com.alura.escola.dominio.aluno.ouvintes;

import br.com.alura.escola.dominio.aluno.eventos.AlunoMatriculado;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado {

    public void reageAo(AlunoMatriculado evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.printf("Aluno com cpf %s matriculado em: %s%n",
                evento.getCpfDoAluno(), momentoFormatado);
    }
}
