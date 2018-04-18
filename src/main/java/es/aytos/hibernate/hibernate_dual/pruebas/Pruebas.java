package es.aytos.hibernate.hibernate_dual.pruebas;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String [] args) {
		
		crearPersona();
	}
	
	private static Integer crearPersona() {
		
		final Persona persona = new Persona();
		persona.setNombre("Amelia");
		persona.setApellidos("Paniagua Gálvez");
		persona.setEdad(36);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("14621307T");
		
		return RepositorioPersona.crearPersona(persona);
	}
	
}
