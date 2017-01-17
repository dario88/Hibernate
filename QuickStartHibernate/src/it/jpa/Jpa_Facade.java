package it.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import it.model.Autore;
import it.model.Libro;

public class Jpa_Facade {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
    
	/**
	 * Usa il file persistence.xml
	 */
	public Jpa_Facade() {
		entityManagerFactory = Persistence.createEntityManagerFactory("QuickStartHibernate-unit");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	
	public Libro createLibro(String titolo, String isbn, Float prezzo, Autore autore) {
		Libro libro = new Libro(titolo, isbn, prezzo, autore);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(libro);
		tx.commit();
		entityManager.close();
		entityManagerFactory.close();
		return libro;
	}
	
	public Autore createAutore(String nome, String cognome, Date dataDiNascita) {
		Autore autore = new Autore(nome, cognome, dataDiNascita);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(autore);
		tx.commit();
		entityManager.close();
		entityManagerFactory.close();
		return autore;
	}
	
	public Libro getLibro(Long id) {
		Libro libro = entityManager.find(Libro.class, id);
		entityManager.close();
		entityManagerFactory.close();
		return libro;
	}
	
	public Autore getAutore(Long id) {
		Autore autore = entityManager.find(Autore.class, id);
		entityManager.close();
		entityManagerFactory.close();
		return autore;
	}
	
	public List<Libro> getAllLibri() {
		CriteriaQuery<Libro> cq = entityManager.getCriteriaBuilder().createQuery(Libro.class);
		cq.select(cq.from(Libro.class));
		List<Libro> libri = entityManager.createQuery(cq).getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return libri;
	}
	
	public List<Autore> getAllAutori() {
		CriteriaQuery<Autore> cq = entityManager.getCriteriaBuilder().createQuery(Autore.class);
		cq.select(cq.from(Autore.class));
		List<Autore> autori = entityManager.createQuery(cq).getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return autori;
	}
	
	public void updateLibro(Libro libro) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(libro);
		tx.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void updateAutore(Autore autore) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(autore);
		tx.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void deleteLibro(Long id) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Libro libro = entityManager.find(Libro.class, id);
		entityManager.remove(libro);
		tx.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void deleteAutore(Long id) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Autore autore = entityManager.find(Autore.class, id);
		entityManager.remove(autore);
		tx.commit();
		entityManager.close();
		entityManagerFactory.close();
	}


}
