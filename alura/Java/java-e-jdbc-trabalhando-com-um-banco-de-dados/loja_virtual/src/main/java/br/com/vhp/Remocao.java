package br.com.vhp;

import java.sql.*;

public class Remocao {
    public static void main(String[] args) throws SQLException {
        Connection con = ConexaoFactory.recuperarConexao();
        PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
        stm.setInt(1, 4);
        stm.execute();
        Integer linhasApagadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas que foram apagadas: " + linhasApagadas);
        con.close();
    }
}
