package br.com.cod3r.factory.app.dbadapter;

import br.com.cod3r.factory.app.dbadapter.db.DB;
import br.com.cod3r.factory.app.dbadapter.db.OracleDB;
import br.com.cod3r.factory.app.dbadapter.factory.OracleDBFactory;
import br.com.cod3r.factory.app.dbadapter.factory.PostgresDBFactory;

public class Client {

	public static void main(String[] args) {
		//DB db = new OracleDBFactory().getDatabase();
		DB db = new PostgresDBFactory().getDatabase();
		db.query("SELECT * FROM users");
		db.update("INSERT INTO users VALUES ('User', 25)");
	}
}
