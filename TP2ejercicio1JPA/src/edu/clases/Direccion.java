package edu.clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //id autogenerado
	private int id;
	@Column
	private String calle;
	@Column
	private String ciudad;
	@OneToMany(mappedBy="domicilio", fetch=FetchType.LAZY)
	/*
	 * una direccion puede ir a muchas personas 
	 * para manejar el mapeo MANY nos vemos obligamos a usar algun tipo de coleccion 
	 * el tipo de fetch = todas las relasciones que se mapean a una lista tienen un fetch que se llaman LAZY
	 * es decir hasta que yo no pida algo de esa lista sobre la base de datos, la lista no hace el fetch porque es muy costoso
	 * la relacion la hago por navegavilidad y no repetida, si yo no digo que ya esta mapeada por el atributo en 
	 * mappedBy "--" en la clase de la lista, generaria otra relacion 
	 * al ser una relacion bidireccional estoy obligado a marcar la navegavilidad en uno de los lados, en gral se prefiere 
	 * marcar la navegavilidad en el lado del que tiene MANY 
	*/
	
	private List<Persona>habitante;
	
	public Direccion() {
		super();
		this.habitante = new ArrayList<Persona>();
	}

	public Direccion(String calle, String ciudad) {
		super();
		this.calle = calle;
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Persona> getHabitante() {
		return habitante;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad  + "]";
	}
	
	
	
}
