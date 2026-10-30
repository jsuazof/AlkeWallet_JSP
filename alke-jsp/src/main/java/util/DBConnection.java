package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
	
	
	private static final String url = System.getenv("DB_URL");
	private static final String user = System.getenv("DB_USER");
	private static final String password = System.getenv("DB_PASSWORD");
	private static final String driver = System.getenv().getOrDefault("DB_DRIVER", "com.mysql.cj.jdbc.Driver");
	private static Connection connection = null;
	
	
	public static Connection getConexion() {
		if (url == null || user == null || password == null) {
			throw new IllegalStateException("Database configuration is missing. Set DB_URL, DB_USER, and DB_PASSWORD.");
		}
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado");
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("No conectado");
			ex.printStackTrace();
		}
		
		return connection;
	}
	
	public static void main(String[] args) {
		getConexion();
		Statement stmt;
		try {
			
			stmt = connection.createStatement();
			
			String consultaSQL = "SELECT * FROM usuarios";
			
			ResultSet rs = stmt.executeQuery(consultaSQL);
			
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String correo = rs.getString("correo");
				String clave = rs.getString("clave");
				Double saldo = rs.getDouble("saldo");
				System.out.println(id + nombre + apellido + correo + clave + saldo);
			}
			
			
			rs.close();
			stmt.close();
			connection.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
