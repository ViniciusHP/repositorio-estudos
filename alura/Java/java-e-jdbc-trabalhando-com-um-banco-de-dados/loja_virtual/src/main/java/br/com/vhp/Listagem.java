package br.com.vhp;

import br.com.vhp.modelo.Produto;

import java.sql.*;

public class Listagem
{
    public static void main( String[] args ) throws SQLException {
        String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";
        Connection con = DriverManager.getConnection(url, usuario, senha);

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
