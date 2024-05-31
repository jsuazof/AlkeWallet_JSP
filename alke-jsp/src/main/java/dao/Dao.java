package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class Dao {

    protected Connection conn;
    protected ResultSet rs;
    private Statement stmt;

    protected void connectionDb() {
        try {
            Properties props = new Properties();
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("dbconfig.properties")) {
                if (input == null) {
                    throw new RuntimeException("No se pudo encontrar el archivo dbconfig.properties");
                }
                props.load(input);
            }

            String connectionString = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            conn = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Conectado a la base de datos");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected ResultSet query(String sql) {
        try {
            this.stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected int executeSql(String sql) {
        try {
            this.stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
