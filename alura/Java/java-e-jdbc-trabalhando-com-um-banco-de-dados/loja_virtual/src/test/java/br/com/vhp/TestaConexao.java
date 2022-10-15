package br.com.vhp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    @Test
    public void deveSeConectarAoBancoEFecharConexao() throws SQLException {
        String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";
        Connection connection = DriverManager.getConnection(url, usuario, senha);
        connection.close();
        assertNotNull(connection);
    }
}
