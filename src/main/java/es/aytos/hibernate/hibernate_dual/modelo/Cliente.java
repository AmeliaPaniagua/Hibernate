package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;

import javax.persistence.*;

//Si el identificador es compuesto habría que crear una clase para poner los dos atributos  y por encima de clase poner la anotación @Embeddedld

@Entity    //la clase Persona va a ser una entidad
@Table(name="A_CLI") // El nombre de la tabla a la que se va a mapear
public class Cliente extends Usuario{

	@Column(name="CLI_NOM", nullable = false, length = 50) // por defecto le indicamos que no puede ser nulo , longitud maxima de 50
	
	private String nombre;
	
	@Column(name="CLI_APE", nullable = false, length = 250)
	private String apellidos;
	
	@Column(name="CLI_DNI", nullable = false, length = 9, unique = true) //la columna DNI va a ser única
	private String dni;
	
	
	@Column(name="CLI_EDA", nullable=false)
	private Integer edad;
	
	@Column(name="CLI_ECV", nullable=false)
	@Enumerated(value=EnumType.STRING)  //busca el enumerado y lo inserta dentro de la persona , Enumerated(value=EnumType.STRING)->inserta en la BD el nombre del estadoCivil y si es .ORDINAL lo inserta como número
	private EstadoCivil estadoCivil;	
	
	
	public Cliente() {
		
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
}
