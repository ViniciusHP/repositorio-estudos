package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GeradorDePagamentoTest {

    private GeradorDePagamento gerador;

    @Mock
    private PagamentoDao pagamentoDao;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
        gerador = new GeradorDePagamento(pagamentoDao);
    }

    @Test
    void deveriaCriarPagamentoParaVencedorDoLeilao() {
        Leilao leilao = getLeilao();
        Lance lanceVencedor = leilao.getLanceVencedor();
        gerador.gerarPagamento(lanceVencedor);

        Mockito.verify(pagamentoDao).salvar(pagamento);
    }

    private Leilao getLeilao() {
        Leilao leilao = new Leilao("Celular", new BigDecimal("500"), new Usuario("Fulano"));
        Lance lance = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));
        leilao.propoe(lance);
        leilao.setLanceVencedor(lance);
        return leilao;
    }
}
