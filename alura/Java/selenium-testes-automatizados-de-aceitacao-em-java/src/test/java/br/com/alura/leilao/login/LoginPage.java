package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        browser.quit();
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

    public void efetuaLogin() {
        browser.findElement(By.id("login-form"))
                .submit();
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
