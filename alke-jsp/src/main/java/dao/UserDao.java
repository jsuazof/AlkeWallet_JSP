package dao;

import model.User;


public interface UserDao {

	public int guardar(User usuario);
	public int depositar(Double monto, int usuarioID);
	public int retirar(Double monto, int usuarioID);
	public User obtenerUsuario(String correo, String clave);
	public User obtenerUsuarioPorID(int usuarioID);
}
