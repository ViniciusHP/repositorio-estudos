package br.com.vhp;

import br.com.vhp.db.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.IntStream;

public class PoolConexao {

    public static void main(String[] args) throws SQLException {
        IntStream.range(0, 20)
            .forEach((indice) -> {
                try {
                    Connection con = DB.getConnection();
                    System.out.println("Conexão de número: " + indice);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
    }
}
