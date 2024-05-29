package dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConfig loadDatabaseConfig() {
        try {
            File file = new File("dbconfig.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(DatabaseConfig.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (DatabaseConfig) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection() {
        DatabaseConfig config = loadDatabaseConfig();
        if (config == null) {
            throw new RuntimeException("Failed to load database configuration.");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            ((JAXBException) e).printStackTrace();
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }
}

