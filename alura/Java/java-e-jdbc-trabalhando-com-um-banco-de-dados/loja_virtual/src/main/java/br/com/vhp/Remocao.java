package br.com.vhp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Remocao {
    public static void main(String[] args) throws SQLException {
        Connection con = ConexaoFactory.recuperarConexao();
        Statement stm = con.createStatement();
        stm.execute("DELETE FROM PRODUTO WHERE ID = 4");
        Integer linhasApagadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas que foram apagadas: " + linhasApagadas);
        con.close();
    }
}
