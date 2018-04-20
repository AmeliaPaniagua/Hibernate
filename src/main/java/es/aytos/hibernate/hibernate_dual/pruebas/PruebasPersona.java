package es.aytos.hibernate.hibernate_dual.pruebas;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
import es.aytos.hibernate.hibernate_dual.modelo.Estudio;
import es.aytos.hibernate.hibernate_dual.modelo.Genero;
import es.aytos.hibernate.hibernate_dual.modelo.Persona;
import es.aytos.hibernate.hibernate_dual.modelo.Telefono;
import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
import es.aytos.hibernate.hibernate_dual.modelo.DetallePersona;
import es.aytos.hibernate.hibernate_dual.modelo.Direccion;
import es.aytos.hibernate.hibernate_dual.modelo.Titulo;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioCliente;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioEstudio;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;
import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioUsuario;

public class PruebasPersona {

	public static void main(String [] args) {
		
	
		
		final Integer idPersona = crearPersona("14621308S", "user1");
		
		//crearCliente("11111111D", "log2");
		//crearPersona("22222222R", "log3");
		//crearCliente("11111111E", "log4");

		
		//comento provisionalmente
//		 modificarPersonaAlCompleto();
//		 modificarClienteAlCompleto();
		
//		 eliminarUsuario(4);
		 
//		 eliminarCliente(4);


		 consultarPersona(idPersona);
		 //comento provisionalmente
//		consultarPersona("%Miguel%", "", "", null, "Miguel1");
//		consultarCliente("%Miguel%", "", "", null, "Miguel2");
		
		 //ES MIO
//			crearEstudio();
		
	}
	
	private static Integer crearPersona(String dni, String login) {
		
		final Persona persona = new Persona();
		persona.setNombre("Amelia");
		persona.setApellidos("Paniagua Galvez");
		persona.setEdad(36);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("123");
		persona.setGenero(Genero.FEMENINO);
		
	
		final Direccion direccion1 = new Direccion();
		direccion1.setProvincia("Sevilla");
		direccion1.setCodigoPostal("41400");
		direccion1.setCalle("C/ Nueva");
		direccion1.setNumero(1);
		direccion1.setPersonas(Arrays.asList(persona));
		
		final Direccion direccion2 = new Direccion();
		direccion2.setProvincia("Sevilla");
		direccion2.setCodigoPostal("41400");
		direccion2.setCalle("C/ Torres Quevedo");
		direccion2.setNumero(10);
		direccion2.setPersonas(Arrays.asList(persona));
		
		final Telefono telefono1 = new Telefono();
		telefono1.setTelefono("650112233");
		telefono1.setPersona(persona);
		
		final Telefono telefono2 = new Telefono();
		telefono2.setTelefono("600445566");
		telefono2.setPersona(persona);
		
		final Telefono telefono3 = new Telefono();
		telefono3.setTelefono("610778899");	
		telefono3.setPersona(persona);
		

		final DetallePersona detalleP = new DetallePersona();
		detalleP.setHijos(false);
		detalleP.setDeporte(true);
		detalleP.setMascotas(false);
		
		persona.setDetalle(detalleP);
		
		persona.setDirecciones(Arrays.asList(direccion1, direccion2));

		//se le añade a la lista de telefonos de la persona
		persona.setTelefonos(new HashSet<>(Arrays.asList(telefono1, telefono2, telefono3)));
		
		detalleP.setPersona(persona);
		
		return RepositorioPersona.crearPersona(persona);
	}
	
	
	private static Integer crearCliente(String dni, String login) {
		
		final Cliente persona = new Cliente();
		persona.setNombre("Pepito");
		persona.setApellidos("Pan Gál");
		persona.setEdad(20);
		persona.setEstadoCivil(EstadoCivil.VIUDO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("123");
		
		return RepositorioCliente.crearCliente(persona);
	}
	
	
	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Lolo");
	}
	
	private static void modificarPersonaAlCompleto() {
		Persona persona = new Persona();
		persona.setApellidos("Romero");
		persona.setDni("12312312D");
		persona.setEdad(29);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setNombre("Maria");
		persona.setIdUsuario(1);
		persona.setFechaAlta(new Date());
		persona.setLogin("Maria");
		persona.setPassword("123");
		RepositorioPersona.modificarPersona(persona);
	}
	
	private static void modificarClienteAlCompleto() {
		Cliente persona = new Cliente();
		persona.setApellidos("Romero");
		persona.setDni("12312312D");
		persona.setEdad(29);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setNombre("Maria");
		persona.setIdUsuario(2);
		persona.setFechaAlta(new Date());
		persona.setLogin("Maria");
		persona.setPassword("123");
		RepositorioCliente.modificarCliente(persona);
}
	
	private static void eliminarPersona(final Integer idPersona) {
		RepositorioPersona.eliminarPersona(idPersona);
	}
	
	private static void eliminarCliente(final Integer idPersona) {
		RepositorioCliente.eliminarCliente(idPersona);
	}
	
	private static void eliminarUsuario(final Integer idPersona) {
		RepositorioUsuario.eliminarUsuario(idPersona);
	}
	
	
	public static void consultarPersona(Integer idPersona) {
		final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
//		System.out.println(persona.getNombre());
//		System.out.println(persona.getApellidos());
//		System.out.println(persona.getDni());
//		System.out.println(persona.getEstadoCivil());
		
		System.out.println(persona.getGenero().getCodigo());
		
		
		System.out.println(persona.getTelefonos());
		
		persona.getTelefonos().stream().forEach(telefono -> System.out.println(telefono.getTelefono()));
		
	}
	
	public static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		
		List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil, login);
		
		System.out.println(personas.size());
	}
	
	private static void consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final List<Cliente> clientes = RepositorioCliente.consultarClientes(nombre, apellidos, dni, estadoCivil, login);
		
		System.out.println(clientes.size());
}
	
	///ESTE ES EL MIO
		private static Integer crearEstudio() {
			
			final Estudio estudio = new Estudio();
			estudio.setTitulo(Titulo.BACHILLERATO);
			estudio.setInstituto("Luis Vélez de Guevara");
			estudio.setDomicilio("C/ Nueva,8");
			estudio.setLocalidad("Écija");
			estudio.setTelefono(954836633);
			
			
			return RepositorioEstudio.crearEstudio(estudio);
		}
		
}
