package it.hibernate.mvc.model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibroBeanRemote {
	
	public void persist(Libro libro);
	
	public Libro getById(Long id);
	
	public List<Libro> getAll();
	
	public Libro update(Libro libro);
	
	public void delete(Libro libro);

}
