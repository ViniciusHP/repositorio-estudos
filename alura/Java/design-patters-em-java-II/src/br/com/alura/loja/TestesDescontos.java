package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesDescontos {

	public static void main(String[] args) {
		Orcamento primeiro = new Orcamento();
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("35")));
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("35")));
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("35")));
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("35")));
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("35")));
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("25")));

		Orcamento segundo = new Orcamento();
		segundo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		segundo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));

		Orcamento terceiro = new Orcamento();
		terceiro.adicionarItem(new ItemOrcamento(new BigDecimal("500")));

		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		System.out.println(calculadora.calcular(primeiro));
		System.out.println(calculadora.calcular(segundo));
		System.out.println(calculadora.calcular(terceiro));
	}

}
