package es.aytos.hibernate.hibernate_dual.modelo;

import java.io.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="A_USU")
//@MAppedSuperClass -> indica que es clase padre
@Inheritance(strategy = InheritanceType.JOINED)//con esta etiqueta crea una unica tabla
public class Usuario implements Serializable {

	// el id va en la clase padre y heredan el id sus hijos
	@Id
	@GeneratedValue
	@Column(name = "USU_ID")
	private int idUsuario;
	
	@Column(name = "USU_LOG", nullable = false, unique = true)
	private String login;
	
	@Column(name = "USU_PAS", nullable = false)
	private String password;
	
	@Column(name = "USU_FEC", nullable = false)
	private Date fechaAlta;
	
	public Usuario(){
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}
