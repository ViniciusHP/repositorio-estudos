package br.com.alura.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {

	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novoLeilaoPage;
	private Browser browser;

	@Dado("o usuário logado")
	public void o_usuário_logado() {
		browser = new Browser();
		loginPage = browser.getLoginPage();
		leiloesPage = loginPage.realizaLoginComoFulano();
	}

	@Quando("acessa a página de novo leilão")
	public void acessa_a_página_de_novo_leilão() {
		novoLeilaoPage = leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}
	
	@Quando("preenche o formulário com dados válidos")
	public void preenche_o_formulário_com_dados_válidos() {
		leiloesPage = novoLeilaoPage.preencheForm("PC Novo", "1500", "13/12/2023");
	}
	
	@Entao("volta para a página de leilões")
	public void volta_para_a_página_de_leilões() {
		Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
	}
	
	@Entao("o novo leilão aparece na tabela")
	public void o_novo_leilão_aparece_na_tabela() {
		Assert.assertTrue(leiloesPage.existe("PC Novo", "1500", "13/12/2023", "fulano"));
		browser.clean();
	}
}
