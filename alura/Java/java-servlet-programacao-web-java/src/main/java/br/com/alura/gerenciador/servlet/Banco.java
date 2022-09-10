package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private Integer ultimoId = 0;

	public void adiciona(Empresa empresa) {
		empresa.setId(ultimoId++);
		
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return lista;
	}

}
