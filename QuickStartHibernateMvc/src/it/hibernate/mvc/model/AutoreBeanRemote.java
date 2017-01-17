package it.hibernate.mvc.model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AutoreBeanRemote {
	
	public void persist(Autore autore);
	
	public Autore getById(Long id);
	
	public List<Autore> getAll();
	
	public Autore update(Autore autore);
	
	public void delete(Autore autore);

}
