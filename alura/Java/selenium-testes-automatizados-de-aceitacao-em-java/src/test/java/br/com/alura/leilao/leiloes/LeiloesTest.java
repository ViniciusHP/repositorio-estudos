package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class LeiloesTest {

    private LeiloesPage paginaLeiloes;

    @AfterEach
    public void afterEach() {
        this.paginaLeiloes.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao() {
        LoginPage paginaLogin = new LoginPage();
        paginaLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaLeiloes = paginaLogin.efetuaLogin();

        CadastroLeilaoPage cadastroLeilaoPage = paginaLeiloes.carregarFormulario();
    }
}
