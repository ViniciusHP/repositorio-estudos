package br.com.alura.bytebank.domain.conta;

import br.com.alura.bytebank.ConnectionFactory;
import br.com.alura.bytebank.domain.RegraDeNegocioException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Optional;
import java.util.Set;

public class ContaService {

    private ConnectionFactory connectionFactory;

    public ContaService() {
        connectionFactory = new ConnectionFactory();
    }

    public Set<Conta> listarContasAbertas() {
        Connection conn = connectionFactory.recuperarConexao();
        return new ContaDAO(conn).listar();
    }

    public BigDecimal consultarSaldo(Integer numeroDaConta) {
        var conta = buscarContaPorNumero(numeroDaConta);
        return conta.getSaldo();
    }

    public void abrir(DadosAberturaConta dadosDaConta) {
        Connection conn = connectionFactory.recuperarConexao();
        new ContaDAO(conn).salvar(dadosDaConta);
    }

    public void realizarSaque(Integer numeroDaConta, BigDecimal valor) {
        var conta = buscarContaPorNumero(numeroDaConta);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do saque deve ser superior a zero!");
        }

        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new RegraDeNegocioException("Saldo insuficiente!");
        }

        if(!conta.getEstaAtiva()) {
            throw new RegraDeNegocioException("Conta não está ativa!");
        }

        BigDecimal novoValor = conta.getSaldo().subtract(valor);
        alterar(numeroDaConta, novoValor);
    }

    public void realizarDeposito(Integer numeroDaConta, BigDecimal valor) {
        var conta = buscarContaPorNumero(numeroDaConta);
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do deposito deve ser superior a zero!");
        }

        if(!conta.getEstaAtiva()) {
            throw new RegraDeNegocioException("Conta não está ativa!");
        }

        BigDecimal novoValor = conta.getSaldo().add(valor);
        alterar(numeroDaConta, novoValor);
    }

    public void encerrar(Integer numeroDaConta) {
        var conta = buscarContaPorNumero(numeroDaConta);
        if (conta.possuiSaldo()) {
            throw new RegraDeNegocioException("Conta não pode ser encerrada pois ainda possui saldo!");
        }

        Connection conn = connectionFactory.recuperarConexao();
        new ContaDAO(conn).deletar(numeroDaConta);
    }

    public void encerrarLogico(Integer numeroDaConta) {
        var conta = buscarContaPorNumero(numeroDaConta);
        if (conta.possuiSaldo()) {
            throw new RegraDeNegocioException("Conta não pode ser encerrada pois ainda possui saldo!");
        }

        Connection conn = connectionFactory.recuperarConexao();
        new ContaDAO(conn).alterarLogico(numeroDaConta);
    }

    public void realizarTransferencia(Integer numeroDaContaOrigem, Integer numeroDaContaDestino, BigDecimal valor) {
        this.realizarSaque(numeroDaContaOrigem, valor);
        this.realizarDeposito(numeroDaContaDestino, valor);
    }

    private Conta buscarContaPorNumero(Integer numero) {
        Connection conn = connectionFactory.recuperarConexao();
        Optional<Conta> contaOptional = new ContaDAO(conn).listarPorNumero(numero);

        return contaOptional.orElseThrow(() -> new RegraDeNegocioException("Não existe conta cadastrada com esse número!"));
    }

    private void alterar(Integer numeroDaConta, BigDecimal novoValor) {
        Connection conn = connectionFactory.recuperarConexao();
        new ContaDAO(conn).alterar(numeroDaConta, novoValor);
    }
}
