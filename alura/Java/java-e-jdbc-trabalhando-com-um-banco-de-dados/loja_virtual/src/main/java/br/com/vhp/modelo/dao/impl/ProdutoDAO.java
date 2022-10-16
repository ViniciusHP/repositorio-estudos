package br.com.vhp.modelo.dao.impl;

import br.com.vhp.modelo.dao.DAOAbstract;
import br.com.vhp.modelo.entity.Categoria;
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
        try (PreparedStatement pstm = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                while (rs.next()) {
                    produto.setId(rs.getInt(1));
                }
            }
        }

        return produto;
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO, CATEGORIA_ID FROM PRODUTO";
        try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rs = pstm.getResultSet()) {
                produtos = extraiListaProdutos(rs);
            }

        }
        return produtos;
    }

    public List<Produto> buscar(Categoria categoria) throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO, CATEGORIA_ID FROM PRODUTO WHERE CATEGORIA_ID = ?";
        try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
            pstm.setInt(1, categoria.getId());
            pstm.execute();

            try (ResultSet rs = pstm.getResultSet()) {
                produtos = extraiListaProdutos(rs);
            }

        }
        return produtos;
    }

    private List<Produto> extraiListaProdutos(ResultSet rs) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        while (rs.next()) {
            Produto produto = extraiProduto(rs);
            produtos.add(produto);
        }
        return produtos;
    }

    private Produto extraiProduto(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("ID");
        String nome = rs.getString("NOME");
        String descricao = rs.getString("DESCRICAO");
        Integer categoriaId = rs.getInt("CATEGORIA_ID");

        Produto produto = Produto.builder()
                .id(id)
                .nome(nome)
                .descricao(descricao)
                .categoriaId(categoriaId)
                .build();

        return produto;
    }
}
