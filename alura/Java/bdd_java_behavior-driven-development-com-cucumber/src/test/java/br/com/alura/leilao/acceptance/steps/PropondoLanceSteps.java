package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	
	private List<Lance> listaLances;
	
	@Before
	public void setup() {
		listaLances = new ArrayList<>();
		leilao = new Leilao("Tablet XPTO");
	}
	
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

	@Dado("um lance de {double} reais do usuário {string}")
	public void um_lance_de_reais_do_usuário_fulano(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		listaLances.add(lance);
	}

	@Quando("propõe vários lances ao leilão")
	public void propõe_vários_lances_ao_leilão() {
		listaLances.forEach(leilao::propoe);
	}
	
	@Entao("os lances são aceitos")
	public void os_lances_são_aceitos() {
		Assert.assertEquals(listaLances.size(), leilao.getLances().size());
		Assert.assertEquals(listaLances.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assert.assertEquals(listaLances.get(1).getValor(), leilao.getLances().get(1).getValor());
	}
	
	@Dado("um lance de {double} reais do usuário com nome {string}")
	public void um_lance_de_reais_do_usuario_com_nome(Double valor, String nomeUsuario) {
	    this.lance = new Lance(new BigDecimal(String.valueOf(valor)));
	}
	
	@Entao("o lance não é aceito")
	public void o_lance_não_é_aceito() {
		Assert.assertEquals(0, leilao.getLances().size());
	}
	
	@Entao("o segundo lance não é aceito")
	public void o_segundo_lance_não_é_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(listaLances.get(0).getValor(), leilao.getLances().get(0).getValor());
	}
	
	@Dado("dois lances")
	public void dois_lances(DataTable dataTable) {
		List<Map<String, String>> mapas = dataTable.asMaps();
		
		for(Map<String, String> mapa: mapas) {
			String nomeUsuario = mapa.get("nomeUsuario");
			BigDecimal valor = new BigDecimal(mapa.get("valor"));
			Lance lance = new Lance(new Usuario(nomeUsuario), valor);
			listaLances.add(lance);
		}
	}
}
