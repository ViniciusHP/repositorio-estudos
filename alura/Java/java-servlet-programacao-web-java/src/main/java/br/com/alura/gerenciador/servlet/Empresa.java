package br.com.alura.gerenciador.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("Id Empresa: %d,%nNome da Empresa: %s,%nData de abertura: %s", id, nome, sdf.format(dataAbertura));
	}
}
