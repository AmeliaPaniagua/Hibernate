package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioUsuario {

	
	public static void eliminarUsuario(Integer idUsuario) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();
			
			sesion.createQuery("DELETE USUARIO where USU_ID = :identificador")
			.setParameter("identificador", idUsuario).executeUpdate();
			
//			final Persona usuarioBBDD = (Persona) sesion.createQuery("from Usuario US where US.idUsuario = :idUsuario")
//					.setParameter("idUsuario", idUsuario).uniqueResult();// Almacena esta persona
//
//			sesion.remove(usuarioBBDD);

			sesion.getTransaction().commit(); // Lo guarda en la base de datos


		} catch (Exception e) {
			System.out.println("Se ha producido un error eliminando el cliente: " + e);
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
	}
	
}
