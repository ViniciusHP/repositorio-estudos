package br.com.vhp;

import br.com.vhp.db.DB;

import java.sql.*;

public class Remocao {
    public static void main(String[] args) throws SQLException {
        Connection con = DB.getConnection();
        PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
        stm.setInt(1, 4);
        stm.execute();
        Integer linhasApagadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas que foram apagadas: " + linhasApagadas);

        DB.closeStatement(stm);
        DB.closeConnection(con);
    }
}
