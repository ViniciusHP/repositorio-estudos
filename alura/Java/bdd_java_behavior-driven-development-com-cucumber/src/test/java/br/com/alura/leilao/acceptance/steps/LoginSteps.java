package br.com.alura.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;

	@Dado("o usuário válido")
	public void o_usuário_válido() {
	    browser = new Browser();
	    browser.seed();
	    loginPage = browser.getLoginPage();
	}
	
	@Quando("realiza login")
	public void realiza_login() {
	    leiloesPage = loginPage.realizaLoginComo("fulano", "pass");
	}
	
	@Entao("é redirecionado para a página de leilões")
	public void é_redirecionado_para_a_página_de_leilões() {
		Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
		browser.clean();
	}
	

	@Dado("o usuário inválido")
	public void o_usuário_inválido() {
		browser = new Browser();
	    browser.seed();
	    loginPage = browser.getLoginPage();
	}

	@Quando("tenta se logar")
	public void tenta_se_logar() {
		leiloesPage = loginPage.realizaLoginComo("fulano", "xpto");
	}
	
	@Entao("continua na página de login")
	public void continua_na_página_de_login() {
		Assert.assertTrue(loginPage.estaNaPaginaDeLoginComErro());
		browser.clean();
	}
}
