package br.com.alura;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    public void adicionarTelefone(String ddd, String numero) {
        telefones.add(new Telefone(ddd, numero));
    }
}
