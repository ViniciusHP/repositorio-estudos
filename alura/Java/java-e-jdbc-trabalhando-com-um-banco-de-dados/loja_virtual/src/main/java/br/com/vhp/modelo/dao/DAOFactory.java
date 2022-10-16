package br.com.vhp.modelo.dao;

import br.com.vhp.db.DB;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class DAOFactory {
    public static ProdutoDAO getProdutoDAO() throws SQLException {
        return new ProdutoDAO(DB.getConnection());
    }

    public static <T extends DAOInterface> T getDAO(Class<T> daoClass) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = daoClass.getConstructor(Connection.class);
        return constructor.newInstance(DB.getConnection());
    }
}
