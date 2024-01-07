package br.com.alura.escola.academico.academico.dominio.aluno.validacoes;

public class LimiteDeTelefonesAtingido extends RuntimeException{

    public LimiteDeTelefonesAtingido() {
        super("Número máximo de telefones já atingido!");
    }
}
