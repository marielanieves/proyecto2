package com.marielanievesfullstack.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class user implements Serializable {
	
	private static final long serialVersionUID = 321891765450725702L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@Column(length = 50)
	private String nombre;
	
	private String apellido;
	
	@Column(name ="mail" , nullable=false, length = 50, unique= true)
	private String email;
	
	private boolean anabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getAnabled() {
		return anabled;
	}

	public void setAnabled(boolean anabled) {
		this.anabled = anabled;
	}
	

}
