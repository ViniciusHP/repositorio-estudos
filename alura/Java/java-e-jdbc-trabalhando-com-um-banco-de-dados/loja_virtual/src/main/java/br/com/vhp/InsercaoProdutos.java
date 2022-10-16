package br.com.vhp;

import br.com.vhp.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsercaoProdutos {

    public static void main(String[] args) throws SQLException {
        Connection con = DB.getConnection();
        Statement stm = con.createStatement();
        stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('MOUSE', 'MOUSE SEM FIO')",
                Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stm.getGeneratedKeys();

        while(rs.next()) {
            int id = rs.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
        DB.closeResultSet(rs);
        DB.closeStatement(stm);
        DB.closeConnection(con);
    }
}
