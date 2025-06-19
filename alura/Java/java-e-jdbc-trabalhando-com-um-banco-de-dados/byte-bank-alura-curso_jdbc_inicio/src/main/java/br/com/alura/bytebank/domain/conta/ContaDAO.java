package br.com.alura.bytebank.domain.conta;

import br.com.alura.bytebank.domain.cliente.Cliente;
import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ContaDAO {

    private Connection conn;

    ContaDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvar(DadosAberturaConta dadosDaConta) {
        var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), cliente, BigDecimal.ZERO, true);

        String sql = """
        INSERT INTO conta (numero, saldo, cliente_nome, cliente_cpf, cliente_email, esta_ativa)
        VALUES (?, ?, ?, ?, ?, ?);
        """;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, conta.getNumero());
            ps.setBigDecimal(2, BigDecimal.ZERO);
            ps.setString(3, dadosDaConta.dadosCliente().nome());
            ps.setString(4, dadosDaConta.dadosCliente().cpf());
            ps.setString(5, dadosDaConta.dadosCliente().email());
            ps.setBoolean(6, true);
            ps.execute();
            ps.close();

            conn.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Set<Conta> listar() {
        String sql = "SELECT * FROM conta WHERE esta_ativa = true;";
        Set<Conta> contas = new HashSet<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Integer numero = rs.getInt("numero");
                BigDecimal saldo = rs.getBigDecimal("saldo");
                String nome = rs.getString("cliente_nome");
                String cpf = rs.getString("cliente_cpf");
                String email = rs.getString("cliente_email");
                Boolean estaAtiva = rs.getBoolean("esta_ativa");

                DadosCadastroCliente dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);
                Cliente cliente = new Cliente(dadosCadastroCliente);

                contas.add(new Conta(numero, cliente, saldo, estaAtiva));
            }

            rs.close();
            ps.close();
            conn.close();
            return contas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Conta> listarPorNumero(Integer numeroConta) {
        String sql = "SELECT numero, saldo, cliente_nome, cliente_cpf, cliente_email, esta_ativa  FROM conta WHERE numero = ? and esta_ativa = true;";
        Set<Conta> contas = new HashSet<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, numeroConta);
            ResultSet rs = ps.executeQuery();

            Conta conta = null;
            if(rs.next()) {
                Integer numero = rs.getInt("numero");
                BigDecimal saldo = rs.getBigDecimal("saldo");
                String nome = rs.getString("cliente_nome");
                String cpf = rs.getString("cliente_cpf");
                String email = rs.getString("cliente_email");
                Boolean estaAtiva = rs.getBoolean("esta_ativa");

                DadosCadastroCliente dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);
                Cliente cliente = new Cliente(dadosCadastroCliente);

                conta = new Conta(numero, cliente, saldo, estaAtiva);
            }

            rs.close();
            ps.close();
            conn.close();

            return conta == null ? Optional.empty() : Optional.of(conta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Integer numero, BigDecimal valor) {
        String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBigDecimal(1, valor);
            ps.setInt(2, numero);

            ps.execute();
            conn.commit();
            ps.close();
            conn.close();
        }catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer numeroDaConta) {
        String sql = "DELETE FROM conta WHERE numero = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, numeroDaConta);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarLogico(Integer numeroDaConta) {
        String sql = "UPDATE conta SET esta_ativa = false WHERE numero = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, numeroDaConta);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
