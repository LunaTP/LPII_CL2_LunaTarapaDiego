package TestEntidades;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl2;

public class TestEntidadUsuario {
	public static void main(String[] args) {
		ClassUsuarioImp crud = new ClassUsuarioImp();
		TblUsuariocl2 nuevo = new TblUsuariocl2();
		
		nuevo.setUsuariocl2("fernando");
		nuevo.setPasswordcl2("paulo");
		
		crud.RegistrarUsuario(nuevo);
		
	}
}
