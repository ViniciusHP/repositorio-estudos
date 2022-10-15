package br.com.vhp;

import java.sql.*;

public class InsersaoComParametros {
    public static void main(String[] args) throws SQLException {
        Connection con = ConexaoFactory.recuperarConexao();

        PreparedStatement stm =
                con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        String nome = "MONITOR";
        String descricao = "MONITOR 4K";

        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();

        ResultSet rs = stm.getGeneratedKeys();

        while(rs.next()) {
            int id = rs.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
        con.close();
    }
}
