package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.*;

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
			e.printStackTrace();
			throw new RuntimeException();
			
		}finally {
			sesion.close(); // hay que cerrar la sesion de hibernate
		}		
		
	}
	
	
	
	
	public static void modificarPersona(final Integer idPersona, String nombre) {
		
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.createQuery("Update Persona set per_nom = :=nombre where per_id :=identificador")
			.setParameter("nombre",  nombre).setParameter("identificador", idPersona).executeUpdate();
			
//			final Persona personaBBDD = (Persona)sesion.createQuery("from Persona where PER_ID = :idPersona") //el :identificador es un parámetro que le pasamos
//					.setParameter("idPersona", idPersona).uniqueResult(); //aquí sustituye el idPersona por el que le damos
//			
//			personaBBDD.setNombre(nombre);

			sesion.getTransaction().commit();
			
		}catch (Exception e) {
			System.out.println("Se ha producido un error modificando la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
			
		}finally {
			sesion.close();
		}
		
	}
	
	
	public static void modificarPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.saveOrUpdate(persona);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error modificando a la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}
	
	
	
	public static void eliminarPersona(final Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			sesion.createQuery("DELETE Usuario where USU_ID = :identificador")
			.setParameter("identificador", idPersona).executeUpdate();

			sesion.getTransaction().commit(); // Lo guarda en la base de datos


		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando la persona: " + e);
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	public static Persona consultarNombreCompleto(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			return (Persona)sesion.createQuery("from Persona where per_id = :idPersona").setParameter("idPersona", idPersona).uniqueResult();


		} catch (Exception e) {
			System.out.println("Se ha producido un error con la consulta: " + e);
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
			
			if(!nombre.isEmpty()) {
				sb.append("and Per_NOM LIKE :nombre");
			}
			if(!apellidos.isEmpty()) {
				sb.append("and PER_APE like :apellidos");
			}
			if(!dni.isEmpty()) {
				sb.append("AND PER_DNI :dni");
			}
			if(estadoCivil != null) {
				sb.append("AND PER_ECV = :estadoCivil");
			}
			if(!login.isEmpty()) {
				sb.append(" and USU_LOG = :login");
			}
			
			
			final Query<Persona> consulta = sesion.createQuery(sb.toString());
			
			if(!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if(!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if(!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if(estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil);
			}
			if (!login.isEmpty()) {
				consulta.setParameter("login", login);
			}
			
			
			return consulta.list();


		} catch (Exception e) {
			System.out.println("Se ha producido un error con la consulta: " + e);
			sesion.getTransaction();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	
	
}
