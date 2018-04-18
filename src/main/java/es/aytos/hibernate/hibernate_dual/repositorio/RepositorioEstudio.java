package es.aytos.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Estudio;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioEstudio {

	public static Integer crearEstudio (Estudio estudio) {
		
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			
			sesion.beginTransaction(); 
			
			final Integer idEstudio = (Integer) sesion.save(estudio); 
			
			sesion.getTransaction().commit(); 
			
			return idEstudio;
			
		}catch(Exception e){
			
			System.out.println("Se ha producido un error insertando el estudio: " + e.getMessage());
			throw new RuntimeException();
			
		}finally {
			sesion.close(); 
		}
		
	}
	
	
	
}
