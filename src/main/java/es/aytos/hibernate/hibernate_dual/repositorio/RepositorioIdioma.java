package es.aytos.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.aytos.hibernate.hibernate_dual.modelo.Idioma;
import es.aytos.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioIdioma {

	
	public static List<Idioma> consultarIdiomas(){
		
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			return sesion.createQuery("from Idioma").setCacheable(true).list();
		}catch(Exception e){
			System.out.println("Se ha producido un error insertando el idioma: "+ e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			sesion.close();
		}
		
	}
	
	
}
