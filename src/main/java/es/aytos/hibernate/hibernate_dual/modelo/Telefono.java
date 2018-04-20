package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.*;

@Entity
@Table(name="A_TEL")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mi-secuencia")
	@SequenceGenerator(name = "mi-secuencia", sequenceName = "Secuencia_bbdd", initialValue = 1, allocationSize = 5)
	@Column(name="TEL_ID")
	private Integer idTelefono;
	
	@Column(name="TEL_NUM", nullable = false, length = 9, unique = true)
	private String telefono;
	
	@ManyToOne
	private Persona persona;
	
	
	public Telefono() {
		
	}


	public Integer getIdTelefono() {
		return idTelefono;
	}


	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
