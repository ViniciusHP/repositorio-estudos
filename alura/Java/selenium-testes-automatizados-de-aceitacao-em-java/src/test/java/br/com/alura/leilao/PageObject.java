package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        this.browser = browser == null ? new ChromeDriver() : browser;
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");


        this.browser.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS) // Tempo de espera para buscar elemento na página até lançar exception
                .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void fechar() {
        browser.quit();
    }
}
