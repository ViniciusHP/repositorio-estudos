package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	
	private Lance lance10;
	private Lance lance15;

	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("Fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
		leilao = new Leilao("Tablet XPTO");
	}

	@Quando("propõe ao leilão")
	public void quando_propõe_o_lance() {
		leilao.propoe(lance);
	}

	@Entao("o lance é aceito")
	public void então_o_lance_é_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	

	@Dado("vários lances válidos")
	public void vários_lances_válidos() {
		Usuario usuario1 = new Usuario("Fulano");
		lance10 = new Lance(usuario1, BigDecimal.TEN);
		
		Usuario usuario2 = new Usuario("Beltrano");
		lance15 = new Lance(usuario2, new BigDecimal("15.0"));
		leilao = new Leilao("Tablet XPTO");
	}

	@Quando("propõe vários lances ao leilão")
	public void propõe_vários_lances_ao_leilão() {
		leilao.propoe(lance10);
		leilao.propoe(lance15);
	}
	
	@Entao("os lances são aceitos")
	public void os_lances_são_aceitos() {
		Assert.assertEquals(2, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		Assert.assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
	}

}
