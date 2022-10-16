package br.com.vhp.modelo.dao;

import br.com.vhp.db.DB;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DAOFactory {
    public static ProdutoDAO getProdutoDAO() throws SQLException {
        return new ProdutoDAO(DB.getConnection());
    }

    public static <T extends DAOInterface> T getDAO(Class<T> daoClass) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T>[] declaredConstructors = (Constructor<T>[]) daoClass.getDeclaredConstructors();

        for(Constructor<T> c : declaredConstructors) {
            if(isConstructorWithConnectionParameter(c)) {
                return getNewInstanceDao(c);
            }
        }

        return null;
    }

    public static <T extends DAOInterface> List<T> getDAOsWithSameConnection(Class<T> ...daosClass) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Connection connection = DB.getConnection();
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
        try {
            return getInstanceWithConnectionParameter(daoClass, DB.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T getInstanceWithConnectionParameter(Class<T> daoClass, Connection connection) {
        try {
            Constructor<T>[] declaredConstructors = (Constructor<T>[]) daoClass.getDeclaredConstructors();

            for(Constructor<T> c : declaredConstructors) {
                if(isConstructorWithConnectionParameter(c)) {
                    return getNewInstanceDao(c, connection);
                }
            }
        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private static <T> T getNewInstanceDao(Constructor<T> constructor) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return getNewInstanceDao(constructor, DB.getConnection());
    }

    private static <T> T getNewInstanceDao(Constructor<T> constructor, Connection connection) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return constructor.newInstance(connection);
    }
}
