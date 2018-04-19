package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioCliente {

	
	public static Integer crearCliente (final Cliente cliente) {
		
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession(); // estamos obteniendo por primera vez la factoria de sesiones
		
		try {
			
			sesion.beginTransaction(); // abrimos la transaccion
			
			final Integer idCliente = (Integer) sesion.save(cliente);  // guardamos el cliente
			
			sesion.getTransaction().commit(); // inserta en la base de datos, a terminado la transacion con la BD
			
			return idCliente;
			
		}catch(Exception e){
			
			System.out.println("Se ha producido un error insertando el cliente: " + e.getMessage());
			throw new RuntimeException();
			
		}finally {
			sesion.close(); // hay que cerrar la sesion de hibernate
		}		
		
	}
	
//	public static void modificarCliente(Integer idCliente, String nombre) {
//		
//		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
//		
//		try {
//			sesion.beginTransaction();
//			
////			sesion.createQuery("Update Persona set per_nom = :=nombre where per_id :=identificador")
////			.setParameter("nombre",  nombre).setParameter("identificador", idPersona).executeUpdate();
//			
//			final Cliente clienteBBDD = (Cliente)sesion.createQuery("from Cliente where PER_ID = :idPersona") //el :identificador es un parámetro que le pasamos
//					.setParameter("idCliente", idCliente).uniqueResult(); //aquí sustituye el idCliente por el que le damos
//			
//			clienteBBDD.setNombre(nombre);
//
//			sesion.getTransaction().commit();
//			
//		}catch (Exception e) {
//			System.out.println("Se ha producido un error insertando el cliente: " + e.getMessage());
//			e.printStackTrace();
//			throw new RuntimeException(e);
//			
//		}finally {
//			sesion.close();
//		}
//		
//	}
	
	public static void modificarCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.saveOrUpdate(cliente);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error modificando al cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

}
	
	
	public static void eliminarCliente(final Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			sesion.createQuery("DELETE Usuario where USU_ID = :identificador")
			.setParameter("identificador", idCliente).executeUpdate();

			sesion.getTransaction().commit(); // Lo guarda en la base de datos


		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando el cliente: " + e);
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	
	
	public static List<Cliente> consultarClientes(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");
			if (!nombre.isEmpty()) {
				sb.append(" and CLI_NOM in (select nombre from Cliente where CLI_NOM like :nombre)");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and CLI_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and CLI_DNI = :dni");
			}
			if (estadoCivil!=null) {
				sb.append(" and CLI_ECV = :estadoCivil");
			}
			if (!login.isEmpty()) {
				sb.append(" and USU_LOG = :login");
}
			
			final Query<Cliente> consulta = sesion.createQuery(sb.toString());
			
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
			System.out.println("Se ha producido un error en la consulta: " + e);
			sesion.getTransaction();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
	
	
	
	
	
}
