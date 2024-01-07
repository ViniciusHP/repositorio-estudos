package br.com.alura.escola.academico.academico.dominio.aluno.eventos;

import br.com.alura.escola.academico.academico.dominio.Evento;
import br.com.alura.escola.shared.dominio.CPF;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    private final CPF cpfDoAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return momento;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
}
