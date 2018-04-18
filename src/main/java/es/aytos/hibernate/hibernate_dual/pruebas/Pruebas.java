package es.aytos.hibernate.hibernate_dual.pruebas;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Estudio;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Titulo;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioEstudio;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String [] args) {
		
		crearPersona();
		crearEstudio();
	
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
	
	private static Integer crearEstudio() {
		
		final Estudio estudio = new Estudio();
		estudio.setTitulo(Titulo.BACHILLERATO);
		estudio.setInstituto("Luis Vélez de Guevara");
		estudio.setDomicilio("C/ Nueva,8");
		estudio.setLocalidad("Écija");
		estudio.setTelefono(954836633);
		
		
		return RepositorioEstudio.crearEstudio(estudio);
	}
	
	private static void modificarPersona() {
		
		final Persona persona = new Persona();
		persona.setNombre("Amelia2");
		persona.setApellidos("Paniagua Gálvez2");
		persona.setEdad(36);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("14621307T");
		persona.setIdPersona(1);
		
		RepositorioPersona.modificarPersona(persona);
		
	}
	
}
