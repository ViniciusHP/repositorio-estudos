package br.com.vhp.modelo.dao;

import java.sql.Connection;

public abstract class DAOAbstract {
    private Connection connection;

    public DAOAbstract(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }
}
