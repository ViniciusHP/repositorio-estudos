package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        paginaLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaLogin.efetuaLogin();

        Assertions.assertFalse(paginaLogin.isPaginaDeLogin());
        Assertions.assertEquals("fulano", paginaLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        paginaLogin.preencheFormularioDeLogin("invalido", "123123");
        paginaLogin.efetuaLogin();

        Assertions.assertTrue(paginaLogin.isPaginaDeLoginComDadosInvalidos());
        Assertions.assertTrue(paginaLogin.contemTexto("Usuário e senha inválidos."));
        Assertions.assertNull(paginaLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaLogin.navegaParaPaginaDeLances();

        Assertions.assertTrue(paginaLogin.isPaginaDeLogin());
        Assertions.assertFalse(paginaLogin.contemTexto("Dados do Leilão"));
    }
}
