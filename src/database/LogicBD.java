package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
//import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Archive;

public class LogicBD {
	
private String mensaje;
	
	private EntityManagerFactory factoria;
	private EntityManager em;
	
	public LogicBD() {
		try {
			//como no puedo crear el JPA, el archivo persistence.xml no lo puedo generar,
			//asi que dejo esto aquí hasta que pueda generarlo
			factoria = Persistence.createEntityManagerFactory("Proyecto");
			em = factoria.createEntityManager();
			this.mensaje = "OK";
		} catch(Exception e) {
			this.mensaje = "Error al conectar a la BD "+e.getMessage();
		}
	}
	
	@Override
	public String toString() {
		return "Mensaje de LogicBD" + mensaje;
	}

	//Me creo un método para crear una query que me devuelva una lista de archivos
	public List<Archive> obtenerArchivos() {
		TypedQuery<Archive> query = em.createNamedQuery("Archive.findAll", Archive.class);
		List<Archive> archivos = query.getResultList();
		return archivos;
	}

}
