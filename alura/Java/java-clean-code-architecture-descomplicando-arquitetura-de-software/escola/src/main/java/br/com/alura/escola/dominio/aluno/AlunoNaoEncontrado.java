package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getNumero());
    }
}
