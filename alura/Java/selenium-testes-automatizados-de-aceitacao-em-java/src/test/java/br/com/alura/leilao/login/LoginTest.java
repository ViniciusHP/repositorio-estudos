package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        browser = new ChromeDriver();
    }

    @AfterEach
    public void afterEach() {
        browser.quit();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        browser.navigate().to(URL_LOGIN);
        browser.findElement(By.id("username"))
                .sendKeys("fulano");

        browser.findElement(By.id("password"))
                .sendKeys("pass");

        browser.findElement(By.id("login-form"))
                .submit();

        Assertions.assertNotEquals(URL_LOGIN, browser.getCurrentUrl());
        Assertions.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        browser.navigate().to(URL_LOGIN);
        browser.findElement(By.id("username"))
                .sendKeys("invalido");

        browser.findElement(By.id("password"))
                .sendKeys("123123");

        browser.findElement(By.id("login-form"))
                .submit();

        Assertions.assertEquals(URL_LOGIN + "?error", browser.getCurrentUrl());
        Assertions.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assertions.assertThrows(NoSuchElementException.class,
                () -> browser.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        browser.navigate().to("http://localhost:8080/leiloes/2");

        Assertions.assertEquals(URL_LOGIN, browser.getCurrentUrl());
        Assertions.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
    }
}
