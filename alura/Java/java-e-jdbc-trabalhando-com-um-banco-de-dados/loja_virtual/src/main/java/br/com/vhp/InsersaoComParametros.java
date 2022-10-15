package br.com.vhp;

import java.sql.*;

public class InsersaoComParametros {
    public static void main(String[] args) throws SQLException {
        Connection con = ConexaoFactory.recuperarConexao();
        con.setAutoCommit(false);

        PreparedStatement stm =
                con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        adicionarProduto("SmartTV", "45 polegadas", stm);
        adicionarProduto("Rádio", "Rádio de bateria", stm);

        ResultSet rs = stm.getGeneratedKeys();

        while(rs.next()) {
            int id = rs.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
        con.close();
    }

    private static void adicionarProduto(String nome, String descricao, PreparedStatement stm ) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();
    }
}
