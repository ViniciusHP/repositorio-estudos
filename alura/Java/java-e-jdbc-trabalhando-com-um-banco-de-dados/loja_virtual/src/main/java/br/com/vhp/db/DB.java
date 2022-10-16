package br.com.vhp.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {

        if(dataSource == null) {
            Properties props = loadProperties();
            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
            comboPooledDataSource.setJdbcUrl(props.getProperty("db-url"));
            comboPooledDataSource.setProperties(props);
            comboPooledDataSource.setMaxPoolSize(Integer.parseInt(props.getProperty("c3p0.max-pool-size")));

            dataSource = comboPooledDataSource;
        }

        return dataSource.getConnection();
    }

    public static void closeConnection(Connection conn) {
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
