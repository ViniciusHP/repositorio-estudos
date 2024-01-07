package br.com.alura.escola.infra.selo;

import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.dominio.selo.Selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private final List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionarSelo(Selo selo) {
        selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAlunoPorCPF(CPF cpf) {
        return selos.stream()
                .filter(s -> s.getCpfDoAluno().equals(cpf))
                .collect(Collectors.toList());
    }
}
