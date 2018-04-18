package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="A_EST")
public class Estudio implements Serializable {

	@Id 
	@GeneratedValue
	@Column(name="EST_ID")
	private int idEstudio;
	
	@Column(name="EST_TIT", nullable = false)
	@Enumerated(value=EnumType.STRING)
	private Titulo titulo;
	
	@Column(name="EST_INS", nullable = false, length = 250)
	private String instituto;
	
	@Column(name="EST_DOM", nullable = false, length = 250)
	private String domicilio;
	
	@Column(name="EST_LOC", nullable = false, length = 50) 
	private String localidad;
	
	@Column(name="EST_TLF")
	private Integer telefono;
	
	

	public int getIdEstudio() {
		return idEstudio;
	}

	public void setIdEstudio(int idEstudio) {
		this.idEstudio = idEstudio;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	
}
