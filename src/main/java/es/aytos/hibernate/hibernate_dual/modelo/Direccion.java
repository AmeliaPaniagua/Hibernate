package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//objeto de modelo direccion asociada con la persona y el tipo de asociacion correspondiente
//crear persona y añadirle direcciones
//eliminar persona y ver que pasa con sus direcciones
//consultar persona y ver si tiene sus direcciones

@Entity
@Table(name="A_DIR")
public class Direccion {

	@Id
	@GeneratedValue
	@Column(name="DIR_ID")
	private Integer idDireccion;
	
	@Column(name="DIR_PRO", nullable = false, length = 50)
	private String provincia;
	
	@Column(name="DIR_CPO", nullable = false, length = 5)
	private String codigoPostal;
	
	@Column(name="DIR_CAL", nullable = false, length = 100)
	private String calle;
	
	@Column(name="DIR_NUM", nullable = false, length = 3)
	private Integer numero;
	
	@Column(name="DIR_BLO")
	private Integer bloque;
	
	@Column(name="DIR_PLA")
	private Integer planta;
	
	@Column(name="DIR_PTA")
	private String puerta;
	
	
	@ManyToMany(mappedBy = "direcciones") //mapperdBy estamos indicando quien es el dueño de la relacion
	private List<Persona> personas = new ArrayList();

	public Direccion() {
		
	}


	public Integer getIdDireccion() {
		return idDireccion;
	}


	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Integer getBloque() {
		return bloque;
	}


	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}


	public Integer getPlanta() {
		return planta;
	}


	public void setPlanta(Integer planta) {
		this.planta = planta;
	}


	public String getPuerta() {
		return puerta;
	}


	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}


	public List<Persona> getPersonas() {
		return personas;
	}


	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}



	
	
	
	
	
}
