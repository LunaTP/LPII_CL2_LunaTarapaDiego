package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IUsuario;
import model.TblUsuariocl2;

public class ClassUsuarioImp implements IUsuario{

	@Override
	public TblUsuariocl2 autenticarUsuario(String nombreUsuario, String contrasena) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();
		
		em.getTransaction().begin();
	
		TblUsuariocl2 usuario = null;
        try {
            TypedQuery<TblUsuariocl2> query = em.createQuery("SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :nombreUsuario AND u.passwordcl2 = :contrasena", TblUsuariocl2.class);
            query.setParameter("nombreUsuario", nombreUsuario);
            query.setParameter("contrasena", contrasena);
            usuario = query.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        
		
		
		return usuario;
	}

	@Override
	public void RegistrarUsuario(TblUsuariocl2 usuario) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_LunaTarapaDiego");
		//Permite gestionar entidades
		EntityManager em = fabr.createEntityManager();
		//Iniciar Tran
		em.getTransaction().begin();

		em.persist(usuario);
		
		System.out.println("Cliente registrado satisfactoriamente");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
