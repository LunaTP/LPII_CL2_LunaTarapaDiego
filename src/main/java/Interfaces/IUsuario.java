package Interfaces;

import model.TblUsuariocl2;

public interface IUsuario {
	public TblUsuariocl2 autenticarUsuario(String nombreUsuario, String contrasena);
	public void RegistrarUsuario (TblUsuariocl2 usuario);
}
