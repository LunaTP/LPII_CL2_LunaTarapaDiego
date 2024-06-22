package TestEntidades;

import java.util.List;

import Dao.ClassProductoImp;
import model.TblProductocl2;

public class TestEntidadProducto {
	public static void main(String[] args) {
		TblProductocl2 producto = new TblProductocl2();
		
		ClassProductoImp crud = new ClassProductoImp();
		/*
		
		producto.setNombrecl2("Aceite");
		producto.setPrecioventacl2(9);
		producto.setPreciocompcl2(11);
		producto.setEstadocl2("vig.");
		producto.setDescripcl2("oferta");
		
		crud.RegistrarProducto(producto);
		*/
		
		
		List<TblProductocl2> lista = crud.ListadoProducto();
		
		for(TblProductocl2 li : lista){
			System.out.println("Producto: " + li.getIdproductocl2() + " ; " + li.getNombrecl2());
		}
		
		
	}
}
