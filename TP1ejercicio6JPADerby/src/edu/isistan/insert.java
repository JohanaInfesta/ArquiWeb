package edu.isistan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Direccion;
import edu.isistan.dao.Persona;

public class insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion d = new Direccion ("Tandil", "Antonena 335");
		em.persist(d);
		Persona p = new Persona(1, "Johana", 31, d);
		Persona p2 = new Persona(2, "Johana 2", 30, d);
		em.persist(p);
		em.persist(p2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
