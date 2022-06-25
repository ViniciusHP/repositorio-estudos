package br.com.alura.alurator.playground.controle;

import java.util.List;

public class Controle {

	public Controle() {}
	public Controle(String s) {}
	private Controle(String s, String t) {}

	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public List<String> getLista() {
		return lista;
	}

	public void metodoControle1() {}
}
