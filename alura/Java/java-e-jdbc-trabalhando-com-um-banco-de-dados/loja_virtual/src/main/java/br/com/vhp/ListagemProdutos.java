package br.com.vhp;

import br.com.vhp.db.DB;
import br.com.vhp.modelo.entity.Produto;

import java.sql.*;

public class ListagemProdutos
{
    public static void main( String[] args ) throws SQLException {
        Connection con = DB.getConnection();

        Statement st = con.createStatement();
        boolean contemRegistros = st.execute("SELECT ID, NOME, DESCRICAO, CATEGORIA_ID FROM PRODUTO");

        ResultSet rs = st.getResultSet();

        while(rs.next()) {
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

            System.out.println(produto);
        }

        DB.closeResultSet(rs);
        DB.closeStatement(st);
        DB.closeConnection(con);
    }
}
