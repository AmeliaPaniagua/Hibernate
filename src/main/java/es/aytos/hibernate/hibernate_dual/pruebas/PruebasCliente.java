//package es.aytos.hibernate.hibernate_dual.pruebas;
//
//import java.util.Date;
//import java.util.List;
//
//import es.aytos.hibernate.hibernate_dual.modelo.Cliente;
//import es.aytos.hibernate.hibernate_dual.modelo.EstadoCivil;
//import es.aytos.hibernate.hibernate_dual.modelo.Estudio;
//import es.aytos.hibernate.hibernate_dual.modelo.Persona;
//import es.aytos.hibernate.hibernate_dual.modelo.Titulo;
//import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioCliente;
//import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioEstudio;
//import es.aytos.hibernate.hibernate_dual.repositorio.RepositorioPersona;
//
//public class PruebasCliente {
//
//public static void main(String [] args) {
//		
//	//final Integer idCliente = crearCliente("1234567L", "123");
//	
////	eliminarCliente(idCliente);
////	
////	modificarCliente(idCliente);
////	consultarCliente(idCliente);
////	consultarCliente("","","", null)
//	
//		crearPersona("12345678R","123");
//		crearPersona("88888888R","111");
//	
//	}
//	
//	private static Integer crearPersona(String dni, String login) {
//		
//		final Persona persona = new Persona();
//		persona.setNombre("Amelia");
//		persona.setApellidos("Paniagua Gálvez");
//		persona.setEdad(36);
//		persona.setEstadoCivil(EstadoCivil.SOLTERO);
//		persona.setDni(dni);
//		persona.setFechaAlta(new Date());
//		persona.setLogin(login);
//		persona.setPassword("123");
//		
//		return RepositorioPersona.crearPersona(persona);
//	}
//	
//	
//	
//	private static void modificarCliente() {
//		final Cliente cliente =new Cliente();
//		cliente.setNombre("Amelia2");
//		cliente.setApellidos("Paniagua2");
//		cliente.setEstadoCivil(EstadoCivil.VIUDO);
//		cliente.setEdad(16);
//		cliente.setDni("1234567E");
//		
//		RepositorioCliente.modificarCliente(4, "Maria");
//	}
//	
//	private static void eliminarCliente(final Integer idCliente) {
//		//RepositorioCliente.eliminarCliente(idCliente);
//	}
//	public static void consultarCliente(final Integer idCliente) {
//		final Cliente cliente = RepositorioCliente.consultarCliente(idCliente);
//		System.out.println(cliente.getNombre());
//		System.out.println(cliente.getApellidos());
//		System.out.println(cliente.getDni());
//		System.out.println(cliente.getEstadoCivil());
//		
//	}
//	public static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
//		List<Persona> personas = RepositorioCliente.consultar(nombre, apellidos, dni, estadoCivil);
//		System.out.println(personas.size());
//}
//	
//	
//	
//	
//}
