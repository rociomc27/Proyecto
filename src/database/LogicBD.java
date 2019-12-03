package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import javax.persistence.TypedQuery;



import entity.Archive;
import entity.User;

public class LogicBD {
	
	private String mensaje;
	private EntityManagerFactory factoria;
	private EntityManager em;
	
	public LogicBD() {
		try {
			factoria = Persistence.createEntityManagerFactory("Proyecto");
			em = factoria.createEntityManager();
			this.mensaje = "OK";
		} catch(Exception e) {
			this.mensaje = "Error al conectar a la BD "+e.getMessage();
		}
	}
	
	@Override
	public String toString() {
		return "Mensaje de LogicBD " + mensaje;
	}

	//Me creo un método para crear una query que me devuelva una lista de archivos
	public List<Archive> obtenerArchivos() {
		TypedQuery<Archive> query1 = em.createNamedQuery("Archive.findAll", Archive.class);
		List<Archive> archivos = query1.getResultList();
		return archivos;
	}
	
	public boolean comprobarUserPass(String username, String password) {
		//TypedQuery<User> query2 = em.createQuery("SELECT u FROM User u WHERE u.userName='"+username+"'", User.class);
		//TypedQuery<User> query3 = em.createQuery("SELECT p FROM User p WHERE p="+password, User.class);
		//User user = query2.getSingleResult();
		//User pass = query3.getSingleResult();
		
		User user = em.find(User.class, username);
		
		if (user==null) {
			//System.out.println("Usuario no encontrado");
			return false;
		}
		else {
			if (user.getUserPass().equals(password)) {
				//System.out.println("OK user y password");
				return true;
			}
			else {
				//System.out.println("User encontrado pero password mal");
				return false;
			}
		}
	
		
	}

}