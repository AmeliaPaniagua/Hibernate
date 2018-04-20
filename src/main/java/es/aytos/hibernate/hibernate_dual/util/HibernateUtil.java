package es.aytos.hibernate.hibernate_dual.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

//crea una SessionFactory, sesiones de hibernate
public class HibernateUtil {

	private static SessionFactory miFactoria = construirSessionFactory();
	
	private static SessionFactory construirSessionFactory() {
		
		try {
			
			return new Configuration().configure().buildSessionFactory();
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error obteniendo la factoría de sesiones: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
			
		}
		
	}
	
	public static SessionFactory getMiFactoria() {
		return miFactoria;
	}
	
}
