package br.com.alura.escola.dominio.aluno.validacoes;

public class LimiteDeTelefonesAtingido extends RuntimeException{

    public LimiteDeTelefonesAtingido() {
        super("Número máximo de telefones já atingido!");
    }
}
