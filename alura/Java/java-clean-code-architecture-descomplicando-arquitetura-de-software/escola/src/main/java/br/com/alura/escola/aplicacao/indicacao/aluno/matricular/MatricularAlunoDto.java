package br.com.alura.escola.aplicacao.indicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;

public class MatricularAlunoDto {

    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public Aluno getAluno() {
        return new Aluno(new CPF(getCpfAluno()),
                nomeAluno,
                new Email(emailAluno));
    }
}
