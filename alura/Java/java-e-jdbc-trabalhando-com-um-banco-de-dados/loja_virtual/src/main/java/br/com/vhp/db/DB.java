package br.com.vhp.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    public static Connection getConnection() {
        if(conn == null) {
            try {
                Properties props = loadProperties();

                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

        return conn;
    }

    public static void closeConnection() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try{
            return readPropertiesArchive("db.properties");
        }catch (IOException | URISyntaxException e) {
            throw new DbException(e.getMessage());
        }
    }

    private static Properties readPropertiesArchive(String name) throws IOException, URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL resource = classloader.getResource(name);
        File file = new File(resource.toURI());

        FileInputStream fs = new FileInputStream(file);
        Properties props = new Properties();

        props.load(fs);
        fs.close();
        return props;
    }

    public static void closeStatement(Statement st) {

        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {

        if(rs != null) {
            try {
                rs.close();
            }catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
