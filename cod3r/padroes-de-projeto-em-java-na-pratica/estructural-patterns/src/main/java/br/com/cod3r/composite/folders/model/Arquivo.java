package br.com.cod3r.composite.folders.model;

public class Arquivo implements FileSystemItem {

    private final String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public void print(String structure) {
        System.out.println(structure + nome);
    }
}
