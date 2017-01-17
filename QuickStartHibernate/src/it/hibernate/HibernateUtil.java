package it.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class creates a SessionFactory object which in turn can open up new Session's.
 * A session is a single-threaded unit of work;
 * the SessionFactory is a thread-safe global object instantiated once.
 *
 */
public class HibernateUtil {
	
	/*
	 * La SessionFactory è il punto centrale, la si può pensare come un contenitore
	 * di tutta la "paccottiglia" di Hibernate specifica della vostra applicazione.
	 *  
	 * La SessionFactory è capace di caricare le informazioni specifiche del
	 * contesto applicativo corrente sia attraverso dei file xml che dei file di properties.
	 * In questo caso utilizziamo il file xml hibernate.cfg.xml
	 * 
	 * Il metodo configure() dell'oggetto Configuration legge le informazioni di
	 * configurazione dal classpath e costruisce di conseguenza una istanza di SessionFactory.
	 * Normalmente la SessionFactory viene resa disponibile in modo statico all'applicazione,
	 * come normalmente avviene per le "factory".
	 * Infatti lo scopo della SessionFactory è quello di fornire delle nuove istanze di
	 * sessioni Hibernate al chiamante tramite il metodo openSession(), per cui
	 * non c'è nessuna problematica di utilizzo concorrente della SessionFactory.
	 */	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/*
	QUESTO MODO DI DEFINIRE LA VARIABILE E POI VALORIZZARLA CON STATIC
	
		private static final SessionFactory sessionFactory;
	
		static {
			...
			...
		}
	
	EQUIVALE A SCRIVERE:
	 
		private static final SessionFactory sessionFactory = buildSessionFactory();
	
		private static SessionFactory buildSessionFactory() {
			...
			...
		}
	
	*/
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
