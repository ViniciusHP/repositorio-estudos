package br.com.vhp.modelo.dao.impl;

import br.com.vhp.modelo.dao.DAOAbstract;
import br.com.vhp.modelo.entity.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends DAOAbstract {

    public ProdutoDAO(Connection connection) {
        super(connection);
    }

    public Produto salvar(Produto produto) throws SQLException {
        String sql =
                """
                    INSERT INTO PRODUTO (nome, descricao)
                    VALUES (?, ?)
                """;
        try(PreparedStatement pstm = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                while(rs.next()) {
                    produto.setId(rs.getInt(1));
                }
            }
        }

        return produto;
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
        try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
            pstm.execute();

            try(ResultSet rs = pstm.getResultSet()) {
                while(rs.next()) {
                    Integer id = rs.getInt("ID");
                    String nome = rs.getString("NOME");
                    String descricao = rs.getString("DESCRICAO");

                    Produto produto = Produto.builder()
                            .id(id)
                            .nome(nome)
                            .descricao(descricao)
                            .build();

                    produtos.add(produto);
                }
            }

        }
        return produtos;
    }
}
