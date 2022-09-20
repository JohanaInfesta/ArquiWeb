package edu.isistan.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * 
 * @author ChoySs
 *
 */
@Entity
public class Persona {
	@Id
	private int id;
	@Column(nullable=false)
	private String Nombre;
	@Column(name="anios")
	private int edad;
	@ManyToOne
	private Direccion domicilio;
	
	public Persona() {
		super();
	}

	public Persona(int id, String nombre, int edad, Direccion domicilio) {
		this.id = id;
		Nombre = nombre;
		this.edad = edad;
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Direccion domicilio) {
		this.domicilio = domicilio;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", Nombre=" + Nombre + ", edad=" + edad + ", domicilio=" + domicilio + "]";
	}
	
	
	
}
