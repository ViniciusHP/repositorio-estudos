package br.com.vhp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    @Test
    public void deveSeConectarAoBancoEFecharConexao() throws SQLException {
        Connection connection = ConexaoFactory.recuperarConexao();
        connection.close();
        assertNotNull(connection);
    }
}
