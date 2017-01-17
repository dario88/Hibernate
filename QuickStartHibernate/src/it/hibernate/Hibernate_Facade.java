package it.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.model.Autore;
import it.model.Libro;

public class Hibernate_Facade {
	
	private SessionFactory sessionFactory;
	
	/**
	 * Usa il file hibernate.cfg.xml
	 */
	public Hibernate_Facade() {
		sessionFactory = HibernateUtil.getSessionFactory();
		//this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		//this.session = HibernateUtil.getSessionFactory().openSession();
	}
	
	
	public Libro createLibro(String titolo, String isbn, Float prezzo, Autore autore) {
		Libro libro = new Libro(titolo, isbn, prezzo, autore);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(libro);
		session.getTransaction().commit();
		session.close();
		return libro;
	}
	
	public Autore createAutore(String nome, String cognome, Date dataDiNascita) {
		Autore autore = new Autore(nome, cognome, dataDiNascita);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(autore);
		session.getTransaction().commit();
		session.close();
		return autore;
	}
	
	public Libro getLibro(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Libro libro = session.load(Libro.class, id);
		session.getTransaction().commit();
		session.close();
		return libro;
	}
	
	public Autore getAutore(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Autore autore = session.load(Autore.class, id);
		session.getTransaction().commit();
		session.close();
		return autore;
	}
	
	public List<Libro> getAllLibri() {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Libro> libri = session.createQuery("from Libro").list();
        session.getTransaction().commit();
        session.close();
        return libri;
	}
	
	public List<Autore> getAllAutori() {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Autore> autori = session.createQuery("from Autore").list();
        session.getTransaction().commit();
        session.close();
        return autori;
	}
	
	public void updateLibro(Libro libro) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(libro);
        session.getTransaction().commit();
        session.close();
	}
	
	public void updateAutore(Autore autore) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(autore);
        session.getTransaction().commit();
        session.close();
	}
	
	public void deleteLibro(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Libro libro = session.load(Libro.class, id);
		if (libro != null)
			session.delete(libro);
        session.getTransaction().commit();
        session.close();
	}
	
	public void deleteAutore(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Autore autore = session.load(Autore.class, id);
		if (autore != null)
			session.delete(autore);
        session.getTransaction().commit();
        session.close();
	}

}
