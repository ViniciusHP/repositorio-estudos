package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Pagamento;
import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.time.*;

public class GeradorDePagamentoTest {

    private GeradorDePagamento gerador;

    @Mock
    private PagamentoDao pagamentoDao;

    @Mock
    private Clock clock;

    @Captor
    private ArgumentCaptor<Pagamento> captor;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
        gerador = new GeradorDePagamento(pagamentoDao, clock);
    }

    @Test
    void deveriaCriarPagamentoParaVencedorDoLeilao() {
        Leilao leilao = getLeilao();
        Lance vencedor = leilao.getLanceVencedor();

        LocalDate dataAtual = LocalDate.of(2022, 10, 31);
        Instant intant = dataAtual.atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        Mockito.when(clock.instant())
                .thenReturn(intant);
        Mockito.when(clock.getZone())
                        .thenReturn(ZoneId.systemDefault());

        gerador.gerarPagamento(vencedor);

        Mockito.verify(pagamentoDao).salvar(captor.capture());
        Pagamento pagamento = captor.getValue();

        Assertions.assertEquals(dataAtual.plusDays(1), pagamento.getVencimento());
        Assertions.assertEquals(vencedor.getValor(), pagamento.getValor());
        Assertions.assertFalse(pagamento.getPago());
        Assertions.assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
        Assertions.assertEquals(vencedor.getLeilao(), pagamento.getLeilao());
    }

    @Test
    void deveriaCriarPagamentoParaVencedorDoLeilaoNaSegundaQuandoVencimentoSerSabado() {
        Leilao leilao = getLeilao();
        Lance vencedor = leilao.getLanceVencedor();

        LocalDate dataAtual = LocalDate.of(2022, 10, 29);
        Instant intant = dataAtual.atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        Mockito.when(clock.instant())
                .thenReturn(intant);
        Mockito.when(clock.getZone())
                .thenReturn(ZoneId.systemDefault());

        gerador.gerarPagamento(vencedor);

        Mockito.verify(pagamentoDao).salvar(captor.capture());
        Pagamento pagamento = captor.getValue();

        Assertions.assertEquals(dataAtual.plusDays(2), pagamento.getVencimento());
        Assertions.assertEquals(vencedor.getValor(), pagamento.getValor());
        Assertions.assertFalse(pagamento.getPago());
        Assertions.assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
        Assertions.assertEquals(vencedor.getLeilao(), pagamento.getLeilao());
    }

    @Test
    void deveriaCriarPagamentoParaVencedorDoLeilaoNaSegundaQuandoVencimentoSerDomingo() {
        Leilao leilao = getLeilao();
        Lance vencedor = leilao.getLanceVencedor();

        LocalDate dataAtual = LocalDate.of(2022, 10, 30);
        Instant intant = dataAtual.atStartOfDay(ZoneId.systemDefault())
                .toInstant();

        Mockito.when(clock.instant())
                .thenReturn(intant);
        Mockito.when(clock.getZone())
                .thenReturn(ZoneId.systemDefault());

        gerador.gerarPagamento(vencedor);

        Mockito.verify(pagamentoDao).salvar(captor.capture());
        Pagamento pagamento = captor.getValue();

        Assertions.assertEquals(dataAtual.plusDays(1), pagamento.getVencimento());
        Assertions.assertEquals(vencedor.getValor(), pagamento.getValor());
        Assertions.assertFalse(pagamento.getPago());
        Assertions.assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
        Assertions.assertEquals(vencedor.getLeilao(), pagamento.getLeilao());
    }

    private Leilao getLeilao() {
        Leilao leilao = new Leilao("Celular", new BigDecimal("500"), new Usuario("Fulano"));
        Lance lance = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));
        leilao.propoe(lance);
        leilao.setLanceVencedor(lance);
        return leilao;
    }
}
