package br.com.vhp;

import br.com.vhp.modelo.Produto;

import java.sql.*;

public class Listagem
{
    public static void main( String[] args ) throws SQLException {
        Connection con = ConexaoFactory.recuperarConexao();

        Statement st = con.createStatement();
        boolean contemRegistros = st.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

        ResultSet rs = st.getResultSet();

        while(rs.next()) {
            Integer id = rs.getInt("ID");
            String nome = rs.getString("NOME");
            String descricao = rs.getString("DESCRICAO");

            Produto produto = new Produto(id, nome, descricao);
            System.out.println(produto);
        }

        con.close();
    }
}
