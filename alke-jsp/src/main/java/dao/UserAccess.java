package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DBConnection;

public class UserAccess implements UserDao {

	private String sql = "";
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private User usuario = null;

	@Override
	public int guardar(User usuario) {
		int row = 0;

		sql = "INSERT INTO usuarios(nombre,apellido,correo,clave,saldo) VALUES (?,?,?,?,?)";

		con = DBConnection.getConexion();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getNombre());
			pstm.setString(2, usuario.getApellido());
			pstm.setString(3, usuario.getCorreo());
			pstm.setString(4, usuario.getClave());
			pstm.setDouble(5, usuario.getSaldo());
			row = pstm.executeUpdate();
			pstm.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public int depositar(Double monto, int usuarioID) {
		int row = 0;

		sql = "UPDATE usuarios SET saldo = saldo + ? WHERE id = ?";
		con = DBConnection.getConexion();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDouble(1, monto);
			pstm.setInt(2, usuarioID);
			row = pstm.executeUpdate();
			pstm.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public int retirar(Double monto, int usuarioID) {
		int row = 0;
		sql = "UPDATE usuarios SET saldo = saldo - ? WHERE id = ?";
		con = DBConnection.getConexion();

		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setDouble(1, monto);
			pstm.setInt(2, usuarioID);
			row = pstm.executeUpdate();
			pstm.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public User obtenerUsuario(String correo, String clave) {
		sql = "SELECT * FROM usuarios WHERE correo = ? AND clave = ?";
		con = DBConnection.getConexion();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, correo);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();

			if (rs.next()) {
				usuario = new User();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setClave(rs.getString("clave"));
				usuario.setSaldo(rs.getDouble("saldo"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}

	@Override
	public User obtenerUsuarioPorID(int usuarioID) {
		sql = "SELECT * FROM usuarios WHERE id = ?";
		con = DBConnection.getConexion();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, usuarioID);
			rs = pstm.executeQuery();

			if (rs.next()) {
				usuario = new User();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setClave(rs.getString("clave"));
				usuario.setSaldo(rs.getDouble("saldo"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}

}
