package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super(null);
        browser.navigate().to(URL_LOGIN);
    }

    public void navegaParaPaginaDeLances() {
        browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public void preencheFormularioDeLogin(String username, String password) {
        browser.findElement(By.id("username"))
                .sendKeys(username);

        browser.findElement(By.id("password"))
                .sendKeys(password);
    }

    public LeiloesPage efetuaLogin() {
        browser.findElement(By.id("login-form"))
                .submit();

        return new LeiloesPage(browser);
    }

    public boolean isPaginaDeLogin() {
        return URL_LOGIN.equals(browser.getCurrentUrl());
    }

    public String getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        }catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public boolean isPaginaDeLoginComDadosInvalidos() {
        StringBuilder sb = new StringBuilder();
        sb.append(URL_LOGIN);
        sb.append("?error");

        return sb.toString().equals(browser.getCurrentUrl());
    }
}
