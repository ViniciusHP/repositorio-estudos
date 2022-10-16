package br.com.vhp.modelo.dao.impl;

import br.com.vhp.modelo.dao.DAOAbstract;
import br.com.vhp.modelo.entity.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
