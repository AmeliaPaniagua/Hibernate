package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.*;
import es.aytos.hibernate.hibernate_dual.util.*;

public class RepositorioPersona {

	public static Integer crearPersona (Persona persona) {
		
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession(); // estamos obteniendo por primera vez la factoria de sesiones
		
		try {
			
			sesion.beginTransaction(); // abrimos la transaccion
			
			final Integer idPersona = (Integer) sesion.save(persona);  // guardamos la persona
			
			sesion.getTransaction().commit(); // inserta en la base de datos, a terminado la transacion con la BD
			
			return idPersona;
			
		}catch(Exception e){
			
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			throw new RuntimeException();
			
		}finally {
			sesion.close(); // hay que cerrar la sesion de hibernate
		}		
		
	}
	
	public static void modificarPersona(Persona persona) {
		
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
//			sesion.createQuery("Update Persona set per_nom = :=nombre where per_id :=identificador")
//			.setParameter("nombre",  nombre).setParameter("identificador", idPersona).executeUpdate();
			
//			final Persona personaBBDD = (Persona)sesion.createQuery("from Persona where PER_ID = :idPersona") //el :identificador es un parámetro que le pasamos
//					.setParameter("idPersona", idPersona).uniqueResult(); //aquí sustituye el idPersona por el que le damos
//			
//			personaBBDD.setNombre(nombre);
//			personaBBDD.setApellidos("2");
//			personaBBDD.setEdad(20);
			
			sesion.saveOrUpdate(persona);
			sesion.getTransaction().commit();
			
		}catch (Exception e) {
			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
			
		}
		
		
	}
	
}
