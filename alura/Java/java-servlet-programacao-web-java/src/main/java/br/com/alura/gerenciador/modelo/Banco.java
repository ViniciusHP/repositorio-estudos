package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer ultimoId = 0;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(ultimoId++);
		empresa.setNome("Alura");
		empresa.setDataAbertura(new Date());
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(ultimoId++);
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(new Date());
		
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("vinicius");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("nico");
		u2.setSenha("12345");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(ultimoId++);
		
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId().equals(id)) {
				it.remove();
			}
		}
		
		/*
		 * lista = lista.stream() .filter(empresa -> !empresa.getId().equals(id))
		 * .toList();
		 */
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		return lista.stream()
				.filter(e -> e.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

}
