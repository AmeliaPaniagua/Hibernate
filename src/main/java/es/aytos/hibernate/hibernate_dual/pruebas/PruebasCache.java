package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.Idioma;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioIdioma;

public class PruebasCache {

	public static void main(String[] args) {
		
		
		//para que funcione en el archivo hibernate.cfg.xml -> tengo que cambiarlo a "update2, ya que como esté en "create" me borra los 
		//datos de la tabla que los he introducido a mano en la bbdd
		consultarIdioma();
	

	}
	
	private static void consultarIdioma() {
		
		final List<Idioma> idiomas = RepositorioIdioma.consultarIdiomas();
		
		idiomas.stream().map(Idioma::getIdioma).forEach(System.out::println);
		
	}

}
