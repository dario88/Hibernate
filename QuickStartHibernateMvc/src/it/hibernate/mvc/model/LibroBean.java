package it.hibernate.mvc.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class LibroBean
 */
@Stateless
@LocalBean
public class LibroBean implements LibroBeanRemote {

	@PersistenceContext(unitName="hibernate-mvc-unit")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public LibroBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persist(Libro libro) {
		em.persist(libro);
	}

	@Override
	public Libro getById(Long id) {
		return em.find(Libro.class, id);
	}

	@Override
	public List<Libro> getAll() {
		return em.createNamedQuery("Libro.findAll", Libro.class).getResultList();
	}

	@Override
	public Libro update(Libro libro) {
		return em.merge(libro);
	}

	@Override
	public void delete(Libro libro) {
		em.remove(em.merge(libro));		
	}

}
