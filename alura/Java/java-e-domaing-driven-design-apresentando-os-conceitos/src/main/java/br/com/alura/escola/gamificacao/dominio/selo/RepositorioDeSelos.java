package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.academico.academico.dominio.aluno.CPF;

import java.util.List;

public interface RepositorioDeSelos {
    void adicionarSelo(Selo selo);
    List<Selo> selosDoAlunoPorCPF(CPF cpf);
}
