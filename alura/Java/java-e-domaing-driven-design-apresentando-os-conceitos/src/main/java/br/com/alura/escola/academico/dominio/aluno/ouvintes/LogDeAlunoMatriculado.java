package br.com.alura.escola.academico.academico.dominio.aluno.ouvintes;

import br.com.alura.escola.academico.academico.dominio.Evento;
import br.com.alura.escola.academico.academico.dominio.Ouvinte;
import br.com.alura.escola.academico.academico.dominio.aluno.eventos.AlunoMatriculado;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    public void reageAo(Evento evento) {
        AlunoMatriculado eventoAlunoMatriculado = (AlunoMatriculado) evento;
        String momentoFormatado = eventoAlunoMatriculado.momento()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.printf("Aluno com cpf %s matriculado em: %s%n",
                eventoAlunoMatriculado.getCpfDoAluno(), momentoFormatado);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
