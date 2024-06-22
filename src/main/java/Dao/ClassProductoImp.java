package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductocl2;

public class ClassProductoImp implements IProducto{

	@Override
	public void RegistrarProducto(TblProductocl2 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_LunaTarapaDiego");
		//Permite gestionar entidades
		EntityManager em = fabr.createEntityManager();
		//Iniciar Tran
		em.getTransaction().begin();
	
		em.persist(producto);
		
		System.out.println("Producto registrado satisfactoriamente");
		
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl2 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
	
		em.merge(producto);
		
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void EliminarProducto(TblProductocl2 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
		
		TblProductocl2 elim = em.merge(producto);
		
		em.remove(elim);
		
		System.out.println("Producto eliminado de la base de datos");
	
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public TblProductocl2 BuscarProducto(TblProductocl2 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
		
		TblProductocl2 buscado = em.find(TblProductocl2.class, producto.getIdproductocl2());
		
		em.getTransaction().commit();
		
		em.close();
		
		return buscado;
	}

	@Override
	public List<TblProductocl2> ListadoProducto() {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
		
		List<TblProductocl2> lista = em.createQuery("select c from TblProductocl2 c",TblProductocl2.class).getResultList();
		
		em.getTransaction().commit();
		
		em.close();
		return lista;
	}

}
