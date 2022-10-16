package br.com.vhp.modelo.dao;

import br.com.vhp.db.DB;
import br.com.vhp.modelo.dao.impl.ProdutoDAO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DAOFactory {
    public static ProdutoDAO getProdutoDAO() throws SQLException {
        return new ProdutoDAO(getConnection());
    }

    public static <T extends DAOAbstract> T getDAO(Class<T> daoClass) {
        return getDAO(daoClass, getConnection());
    }

    public static <T extends DAOAbstract> T getDAO(Class<T> daoClass, Connection connection) {
        Constructor<T>[] declaredConstructors = (Constructor<T>[]) daoClass.getDeclaredConstructors();
        for(Constructor<T> c : declaredConstructors) {
            if(isConstructorWithConnectionParameter(c)) {
                return getNewInstanceDao(c, connection);
            }
        }
        return null;
    }

    public static <T extends DAOAbstract> List<T> getDAOsWithSameConnection(Class<T> ...daosClass) {
        final Connection connection = getConnection();
        return Arrays.asList(daosClass)
                .stream()
                .map((daoClass) -> getInstanceWithConnectionParameter(daoClass, connection))
                .toList();
    }

    private static boolean isConstructorWithConnectionParameter(Constructor<?> c) {
        Parameter[] paramsConstructor = c.getParameters();

        if(paramsConstructor.length != 1) {
            return false;
        }

        Parameter parameter = paramsConstructor[0];
        return parameter.getType().equals(Connection.class);
    }

    private static <T> T getInstanceWithConnectionParameter(Class<T> daoClass) {
        return getInstanceWithConnectionParameter(daoClass, getConnection());
    }

    private static <T> T getInstanceWithConnectionParameter(Class<T> daoClass, Connection connection) {
        Constructor<T>[] declaredConstructors = (Constructor<T>[]) daoClass.getDeclaredConstructors();

        for(Constructor<T> c : declaredConstructors) {
            if(isConstructorWithConnectionParameter(c)) {
                return getNewInstanceDao(c, connection);
            }
        }

        return null;
    }

    private static <T> T getNewInstanceDao(Constructor<T> constructor) {
        return getNewInstanceDao(constructor, getConnection());
    }

    private static <T> T getNewInstanceDao(Constructor<T> constructor, Connection connection) {
        try {
            return constructor.newInstance(connection);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() {
        try {
            return DB.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
