package it.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.hibernate.Hibernate_Facade;
import it.model.Autore;
import it.model.Libro;

public class Hibernate_main {
	
	public static void main(String[] args) {
		
		Hibernate_Facade hibernateFacade = new Hibernate_Facade();
		
		Calendar cal = Calendar.getInstance();
		cal.set(1988, Calendar.JANUARY, 14);
		Date dataDiNascita = cal.getTime();
		Autore deaver = hibernateFacade.createAutore("Jeffery", "Deaver", dataDiNascita);
		
		/*
		 * devo creare una nuova facade perchè ogni metodo al suo interno
		 * una volta eseguita la query chiude la session
		 * 
		 * questo è normale perchè generalmente useremo hibernate con mvc,
		 * e quindi ad ogni richiesta corrisponderà una nuova chiamata alla factory
		 */		
		hibernateFacade = new Hibernate_Facade();
		hibernateFacade.createLibro("Il collezionista di ossa", "88-454-2261-5", 4.99F, deaver);
		hibernateFacade = new Hibernate_Facade();
		hibernateFacade.createLibro("Lo scheletro che balla", "88-454-2427-8", 9.99F, deaver);
		
		hibernateFacade = new Hibernate_Facade();
		List<Libro> libri = hibernateFacade.getAllLibri();
		for (Libro l : libri)
			System.out.println(l.toString());
	}
	
	

}
