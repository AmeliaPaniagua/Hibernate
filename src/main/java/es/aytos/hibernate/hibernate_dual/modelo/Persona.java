package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.SortNatural;

import es.aytos.hibernate.hibernate_dual.conversores.ConversorGenero;

//Si el identificador es compuesto habría que crear una clase para poner los dos atributos  
//y por encima de clase poner la anotación @Embeddedld

@Entity    //la clase Persona va a ser una entidad, es decir un tabla
@Table(name="A_PER") // El nombre de la tabla a la que se va a mapear
public class Persona extends Usuario{

	//Esta entidad es hija por lo que el padre tendrá el ID
	//comentamos entonces @Id
	
//	@Id  // este atributo será la pk en la tabla
//	@GeneratedValue // La pk que es el id se crea por defecto automáticamente
//	@Column(name="PER_ID")  //nos indica el nombre de la columna de la tabla
//	private int idPersona;
	
	
	@Column(name="PER_NOM", nullable = false, length = 50) // por defecto le indicamos que no puede ser nulo , longitud maxima de 50
	
	private String nombre;
	
	@Column(name="PER_APE", nullable = false, length = 250)
	private String apellidos;
	
	@Column(name="PER_DNI", nullable = false, length = 9, unique = true) //la columna DNI va a ser única
	private String dni;
	
	
	@Column(name="PER_EDA", nullable=false)
	private Integer edad;
	
	@Column(name="PER_ECV", nullable=false)
	@Enumerated(value=EnumType.STRING)  //busca el enumerado y lo inserta dentro de la persona , Enumerated(value=EnumType.STRING)->inserta en la BD el nombre del estadoCivil y si es .ORDINAL lo inserta como número
	private EstadoCivil estadoCivil;	
	
	//Bidireccional
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Direccion> direcciones = new ArrayList<>();
	
	//Bidireccional
	
	//Hace la ordención en BBDD
	// @OrderBy("TEL_NUM") -> ordena por defecto de forma ascendente  // ordena por campo de la bbdd
	// @OrderBy("TEL_NUM DESC") -> ordena de forma descendiente
	//@OrderColumn(name = "TEL_NUM") -> ordena por columna.
	
	//Hace la ordenación en memoria con la interfaz comparable
	// hay que crear compareTo en Telefono e implementar en la clase
	
	//@SortNatural
	//@SortComparator
	
	@OrderBy("TEL_NUM")
	@OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval= true)
	private Set<Telefono> telefonos;
	
	//Bidireccional
	@OneToOne(cascade = CascadeType.ALL)
	private DetallePersona detalle;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Idioma> idiomas; //en la clase idioma al asociar tendré que indicarle mappedBy = "idiomas"
	
	@Column(name = "PER_GEN", nullable = false, length = 1)
	@Convert(converter = ConversorGenero.class)
	private Genero genero;
	
	
	public List<Idioma> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public Persona() {
		//Es obligatorio un constructor vacio
	}
	

	//los getter y setter son obligatorios todos
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


	public List getDirecciones() {
		return direcciones;
	}


	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}


	public Set<Telefono> getTelefonos() {
		return telefonos;
	}


	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}


	public DetallePersona getDetalle() {
		return detalle;
	}


	public void setDetalle(DetallePersona detalle) {
		this.detalle = detalle;
	}
	
	
	
}
