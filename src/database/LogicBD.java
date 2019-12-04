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

	//M�todo que crea una query con una lista de archivos
	public List<Archive> obtenerArchivos() {
		TypedQuery<Archive> query1 = em.createNamedQuery("Archive.findAll", Archive.class);
		List<Archive> archivos = query1.getResultList();
		return archivos;
	}
	
	public boolean comprobarUserPass(String username, String password) {
				
		User user = em.find(User.class, username);
		
		if (user==null) {
			return false; //Usuario no encontrado
		}
		else {
			if (user.getUserPass().equals(password)) {
				return true;//Usuario y contrase�a correctos
			}
			else {
				return false; //Usuario correcto, contrase�a incorrecta
			}
		}
	}
	
	//Hay que cambiar de contrase�a. Registrar nuevos usuarios.
	public boolean cambioContrasena(String username, String password, String newPass) {
		if (comprobarUserPass(username, password) == true) {
			User user = em.find(User.class, username);
			EntityTransaction et = em.getTransaction();
			et.begin();
			user.setUserPass(newPass);
			em.merge(user);
			et.commit();
			return true;
		}else {
			return false;
		}
		
		
	}
}