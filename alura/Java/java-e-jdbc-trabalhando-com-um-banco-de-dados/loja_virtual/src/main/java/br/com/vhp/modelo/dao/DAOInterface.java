package br.com.vhp.modelo.dao;

import java.sql.Connection;

public abstract class DAOInterface {
    private Connection connection;

    public DAOInterface(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }
}
