package it.hibernate.mvc.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AutoreBean
 */
@Stateless
@LocalBean
public class AutoreBean implements AutoreBeanRemote {

	@PersistenceContext(unitName="hibernate-mvc-unit")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public AutoreBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void persist(Autore autore) {
		em.persist(autore);
	}

	@Override
	public Autore getById(Long id) {
		return em.find(Autore.class, id);
	}

	@Override
	public List<Autore> getAll() {
		return em.createNamedQuery("Autore.findAll", Autore.class).getResultList();
	}

	@Override
	public Autore update(Autore autore) {
		return em.merge(autore);
	}

	@Override
	public void delete(Autore autore) {
		em.remove(em.merge(autore));		
	}

}
