package es.aytos.hibernate.hibernate_dual.modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "A_IDI")
public class Idioma {

	@Id
	@Column(name="IDI_ID")
	private Integer idIdioma;
	
	
	@Column(name="IDI_NOM", nullable = false)
	private String idioma;

	@ManyToMany(mappedBy = "idiomas")
	private List<Persona> persona;
	
	public Idioma() {
		
	}

	public Integer getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	
	
	
}
