package es.aytos.hibernate.hibernate_dual.modelo;

import javax.persistence.*;

//si tiene hijos le gusta el deporte tiene mascotas ->booleano 


@Entity
@Table(name="A_DET")
public class DetallePersona {
	
	//https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-one
	//SQL SERVER 2012 Express
	@Id
	@GeneratedValue
	@Column(name="DET_ID")
	private Integer idDetalle;
	
	@Column(name="DET_HIJ")
	private Boolean hijos;
	
	@Column(name="DET_DEP")
	private Boolean deporte;
	
	@Column(name="DET_MAS")
	private Boolean mascotas;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PER") //indicamos la tabla con la k queremos hacer relacion
	private Persona persona;
	
	public DetallePersona() {
		
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Boolean getHijos() {
		return hijos;
	}

	public void setHijos(Boolean hijos) {
		this.hijos = hijos;
	}

	public Boolean getDeporte() {
		return deporte;
	}

	public void setDeporte(Boolean deporte) {
		this.deporte = deporte;
	}

	public Boolean getMascotas() {
		return mascotas;
	}

	public void setMascotas(Boolean mascotas) {
		this.mascotas = mascotas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
