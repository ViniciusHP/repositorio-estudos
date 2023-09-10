package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        this.paginaLeiloes = paginaLogin.efetuaLogin();

        CadastroLeilaoPage paginaCadastro = paginaLeiloes.carregarFormulario();

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valor = "500.00";

        this.paginaLeiloes = paginaCadastro.cadastrarLeilao(nome, valor, hoje);
        Assertions.assertTrue(paginaLeiloes.isLeilaoCadastrado(nome, valor, hoje));
    }
}
