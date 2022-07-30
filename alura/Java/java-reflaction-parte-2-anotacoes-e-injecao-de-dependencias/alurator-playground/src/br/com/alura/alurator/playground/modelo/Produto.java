package br.com.alura.alurator.playground.modelo;

import br.com.alura.alurator.playground.anotacao.NomeTagXML;

@NomeTagXML("produto")
public class Produto extends SuperProduto{

    @NomeTagXML("n")
    private String nome;

    @NomeTagXML("v")
    private double valor;

    @NomeTagXML("m")
    private String marca;

    public Produto(String nome, double valor, String marca) {
        this.nome = nome;
        this.valor = valor;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
