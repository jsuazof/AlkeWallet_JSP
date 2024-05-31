package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class UserDao extends Dao {

    public boolean validateUser(String email, String password) {
        String query = "SELECT * FROM customers WHERE email = ? AND password = ?";
        try {
            connectionDb();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }

    public Customer getCustomerByEmail(String email) {
        String query = "SELECT * FROM customers WHERE email = ?";
        try {
            connectionDb();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("rut"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }
}

