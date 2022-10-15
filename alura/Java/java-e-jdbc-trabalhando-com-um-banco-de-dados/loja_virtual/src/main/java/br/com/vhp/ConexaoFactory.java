package br.com.vhp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
    private static String usuario = "root";
    private static String senha = "root";

    public static Connection recuperarConexao() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}
