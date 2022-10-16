package br.com.vhp;

import br.com.vhp.db.DB;
import br.com.vhp.modelo.Produto;

import java.sql.*;

public class InsercaoComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = Produto.builder()
                .nome("Cômoda")
                .descricao("Cômoda Vertical")
                .build();
        String sql =
            """
                INSERT INTO PRODUTO (nome, descricao)
                VALUES (?, ?)
            """;
        try(Connection con = DB.getConnection()) {
            try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, comoda.getNome());
                pstm.setString(2, comoda.getDescricao());
                pstm.execute();

                try (ResultSet rs = pstm.getGeneratedKeys()) {
                    while(rs.next()) {
                        comoda.setId(rs.getInt(1));
                    }
                }
            }
        }

        System.out.println(comoda);
    }
}
