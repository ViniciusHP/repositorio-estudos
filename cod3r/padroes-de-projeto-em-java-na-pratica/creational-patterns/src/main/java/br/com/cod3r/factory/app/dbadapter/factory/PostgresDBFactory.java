package br.com.cod3r.factory.app.dbadapter.factory;

import br.com.cod3r.factory.app.dbadapter.db.DB;
import br.com.cod3r.factory.app.dbadapter.db.PostgresDB;

public class PostgresDBFactory implements DBFactory{
    @Override
    public DB getDatabase() {
        return new PostgresDB();
    }
}
