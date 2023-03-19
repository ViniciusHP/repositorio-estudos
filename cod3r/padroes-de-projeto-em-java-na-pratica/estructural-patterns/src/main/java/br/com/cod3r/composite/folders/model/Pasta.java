package br.com.cod3r.composite.folders.model;

import java.util.Arrays;
import java.util.List;

public class Pasta implements FileSystemItem{

    private final String nome;
    private List<FileSystemItem> children;

    public Pasta(String nome, FileSystemItem... children) {
        this(nome, Arrays.asList(children));
    }

    public Pasta(String nome, List<FileSystemItem> children) {
        this.nome = nome;
        this.children = children;
    }

    @Override
    public void print(String structure) {
        System.out.println(structure + nome);
        for(FileSystemItem child: children) {
            child.print(structure + "|\t");
        }
    }
}
