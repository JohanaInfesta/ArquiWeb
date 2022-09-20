package edu.clases;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Persona {
	
	@Id
	private int id;
	@Column(name="anios")
	private int anios;
	@Column(nullable=false)
	private String nombre;
	@ManyToOne
	private Direccion domicilio;
	
	//la persona quiere acceder a todos sus turnos, tiene que tener un mapeo de la relacion ManyToMany de turno
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "jugadores")
	private List<Turno>turnos;
	
	public Persona() {
		super();
	}

	public Persona(int id, int anios, String nombre, Direccion domicilio) {
		super();
		this.id = id;
		this.anios = anios;
		this.nombre = nombre;
		this.domicilio = domicilio;
	}

	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Persona [id=" + id + ", anios=" + anios + ", nombre=" + nombre + ", domicilio=" + domicilio + "]";
	}
	
	
	
}
