package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DBConnection;

public class UserAccess implements UserDao {

	private final String INSERT_SQL = "INSERT INTO usuarios(nombre, apellido, correo, clave, saldo) VALUES (?, ?, ?, ?, ?)";
	private final String UPDATE_DEPOSIT_SQL = "UPDATE usuarios SET saldo = saldo + ? WHERE id = ?";
	private final String UPDATE_REMOVE_SQL = "UPDATE usuarios SET saldo = saldo - ? WHERE id = ?";
	private final String SELECT_BY_EMAIL_PASS_SQL = "SELECT * FROM usuarios WHERE correo = ? AND clave = ?";
	private final String SELECT_BY_ID_SQL = "SELECT * FROM usuarios WHERE id = ?";

	@Override
	public int guardar(User usuario) {
		try (Connection con = DBConnection.getConexion();
			 PreparedStatement pstm = con.prepareStatement(INSERT_SQL)) {
			pstm.setString(1, usuario.getNombre());
			pstm.setString(2, usuario.getApellido());
			pstm.setString(3, usuario.getCorreo());
			pstm.setString(4, usuario.getClave());
			pstm.setDouble(5, usuario.getSaldo());
			return pstm.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int depositar(Double monto, int usuarioID) {
		try (Connection con = DBConnection.getConexion();
			 PreparedStatement pstm = con.prepareStatement(UPDATE_DEPOSIT_SQL)) {
			pstm.setDouble(1, monto);
			pstm.setInt(2, usuarioID);
			return pstm.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int retirar(Double monto, int usuarioID) {
		try (Connection con = DBConnection.getConexion();
			 PreparedStatement pstm = con.prepareStatement(UPDATE_REMOVE_SQL)) {
			pstm.setDouble(1, monto);
			pstm.setInt(2, usuarioID);
			return pstm.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public User obtenerUsuario(String correo, String clave) {
		try (Connection con = DBConnection.getConexion();
			 PreparedStatement pstm = con.prepareStatement(SELECT_BY_EMAIL_PASS_SQL)) {
			pstm.setString(1, correo);
			pstm.setString(2, clave);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return extractUserFromResultSet(rs);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public User obtenerUsuarioPorID(int usuarioID) {
		try (Connection con = DBConnection.getConexion();
			 PreparedStatement pstm = con.prepareStatement(SELECT_BY_ID_SQL)) {
			pstm.setInt(1, usuarioID);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return extractUserFromResultSet(rs);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
		User usuario = new User();
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellido(rs.getString("apellido"));
		usuario.setCorreo(rs.getString("correo"));
		usuario.setClave(rs.getString("clave"));
		usuario.setSaldo(rs.getDouble("saldo"));
		return usuario;
	}
}
