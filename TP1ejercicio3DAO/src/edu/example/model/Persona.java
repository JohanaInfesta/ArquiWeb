package edu.example.model;
/**
 * Persona
 * @author ChoySs
 *
 */
public class Persona {

	private Integer id;
	private String name;
	private Integer year;
	
	public Persona() {
		id = null;
		name = null;
		year = null;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	
}
