package edu.example.dao;

import edu.example.db.CreacionTablaPersona;
import edu.example.model.Persona;

public class main {

	public static void main(String[] args) {
		CreacionTablaPersona newDB = new CreacionTablaPersona();
		newDB.CracionDB();

		PersonaDAOImplementacion personaDAO;
		personaDAO = new PersonaDAOImplementacion();
		Persona p = new Persona();
		p.setId(1);
		p.setName("Johana");
		p.setYear(31);
		personaDAO.insert(p);
		
	}

}
