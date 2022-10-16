package br.com.vhp.modelo.dao;

import br.com.vhp.db.DB;
import br.com.vhp.modelo.entity.Produto;
import lombok.AllArgsConstructor;

import java.sql.*;

public class ProdutoDAO extends DAOInterface{

    public ProdutoDAO(Connection connection) {
        super(connection);
    }

    public Produto salvar(Produto produto) throws SQLException {
        String sql =
                """
                    INSERT INTO PRODUTO (nome, descricao)
                    VALUES (?, ?)
                """;
        try(Connection con = DB.getConnection()) {
            try(PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, produto.getNome());
                pstm.setString(2, produto.getDescricao());
                pstm.execute();

                try (ResultSet rs = pstm.getGeneratedKeys()) {
                    while(rs.next()) {
                        produto.setId(rs.getInt(1));
                    }
                }
            }
        }

        return produto;
    }
}
