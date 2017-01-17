package it.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.model.Libro;
import it.model.Autore;

public class Jpa_main {
	
	public static void main(String[] args) {
		
		Jpa_Facade jpaFacade = new Jpa_Facade();
		
		Calendar cal = Calendar.getInstance();
		cal.set(1988, Calendar.JANUARY, 14);
		Date dataDiNascita = cal.getTime();
		Autore deaver = jpaFacade.createAutore("Jeffery", "Deaver", dataDiNascita);
		
		/*
		 * devo creare una nuova facade perchè ogni metodo al suo interno
		 * una volta eseguita la query chiude l'entity manager
		 * 
		 * questo è normale perchè generalmente useremo hibernate con mvc,
		 * e quindi ad ogni richiesta corrisponderà una nuova chiamata alla facade
		 */		
		jpaFacade = new Jpa_Facade();
		jpaFacade.createLibro("Il collezionista di ossa", "88-454-2261-5", 4.99F, deaver);
		jpaFacade = new Jpa_Facade();
		jpaFacade.createLibro("Lo scheletro che balla", "88-454-2427-8", 9.99F, deaver);
		
		jpaFacade = new Jpa_Facade();
		List<Libro> libri = jpaFacade.getAllLibri();
		for (Libro l : libri)
			System.out.println(l.toString());
		
	}

}
