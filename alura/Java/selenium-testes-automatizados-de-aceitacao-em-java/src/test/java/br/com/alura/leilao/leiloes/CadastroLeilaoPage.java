package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class CadastroLeilaoPage extends PageObject {

    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

    public CadastroLeilaoPage(WebDriver browser) {
        super(browser);
    }

    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        browser.findElement(By.id("nome"))
                .sendKeys(nome);

        browser.findElement(By.id("valorInicial"))
                .sendKeys(valorInicial);

        browser.findElement(By.id("dataAbertura"))
                .sendKeys(dataAbertura);

        browser.findElement(By.id("button-submit"))
                .click();

        return new LeiloesPage(browser);
    }

    public boolean isPaginaAtual() {
        return URL_CADASTRO_LEILAO.equals(browser.getCurrentUrl());
    }

    public boolean isMensagensDeValidacoesVisiveis() {
        final String pageSource = browser.getPageSource();
        List<String> mensagensValidacao = Arrays.asList("minimo 3 caracteres",
                "não deve estar em branco",
                "deve ser um valor maior de 0.1",
                "deve ser uma data no formato dd/MM/yyyy");

        return mensagensValidacao.stream()
                .allMatch(pageSource::contains);
    }
}
