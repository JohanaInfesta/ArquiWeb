package edu.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.clases.Direccion;
import edu.clases.Persona;


public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion d = new Direccion ("Tandil", "Antonena 335");
		em.persist(d);
		Persona p = new Persona(1, 31, "Johana",  d);
		Persona p2 = new Persona(2, 30,"Johana 2", d);
		em.persist(p);
		em.persist(p2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
