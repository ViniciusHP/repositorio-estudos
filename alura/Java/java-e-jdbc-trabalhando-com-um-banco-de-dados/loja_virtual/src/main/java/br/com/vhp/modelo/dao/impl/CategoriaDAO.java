package br.com.vhp.modelo.dao.impl;

import br.com.vhp.modelo.dao.DAOAbstract;
import br.com.vhp.modelo.entity.Categoria;
import br.com.vhp.modelo.entity.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoriaDAO extends DAOAbstract {

    public CategoriaDAO(Connection connection) {
        super(connection);
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        Connection connection = getConnection();
        String sql = "SELECT ID, NOME FROM CATEGORIA";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try(ResultSet rs = pstm.getResultSet()) {
                while(rs.next()) {
                    Integer id = rs.getInt("ID");
                    String nome = rs.getString("NOME");

                    Categoria categoria = Categoria.builder()
                            .id(id)
                            .nome(nome)
                            .build();

                    categorias.add(categoria);
                }
            }
        }

        return categorias;
    }

    public List<Categoria> listarComProdutos() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        Connection connection = getConnection();
        String sql =
            """
                SELECT C.ID , C.NOME, P.ID, P.NOME, P.DESCRICAO
                FROM CATEGORIA C
                INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID
            """;

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try(ResultSet rs = pstm.getResultSet()) {
                while(rs.next()) {
                    Integer categoriaId = rs.getInt(1);
                    String categoriaNome = rs.getString(2);
                    Integer produtoId = rs.getInt(3);
                    String produtoNome = rs.getString(4);
                    String produtoDescricao = rs.getString(5);

                    Categoria categoria = Categoria.builder()
                            .id(categoriaId)
                            .nome(categoriaNome)
                            .build();

                    Produto produto = Produto.builder()
                            .id(produtoId)
                            .nome(produtoNome)
                            .descricao(produtoDescricao)
                            .categoriaId(categoriaId)
                            .build();

                    int indiceCategoria = categorias.indexOf(categoria);

                    if(indiceCategoria != -1) {
                       categoria = categorias.get(indiceCategoria);
                    } else {
                        categorias.add(categoria);
                    }

                    categoria.adicionarProduto(produto);
                }
            }
        }

        return categorias;
    }
}
