package it.hibernate.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Libro.findAll", query = "SELECT l FROM Libro l"),
	@NamedQuery(name="Libro.findByTitolo", query="SELECT l FROM Libro l WHERE l.titolo = :titolo"),
	@NamedQuery(name="Libro.findById", query="SELECT l FROM Libro l WHERE l.id = :id")
})
@Table(name="LIBRO")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String titolo;
	@Column(nullable=false, length=13)
	private String isbn;
	private Float prezzo;
	@ManyToOne
	private Autore autore;
	
	public Libro() {
		
	}
	
	public Libro(String titolo) {
		this.titolo = titolo;
	}
	
	public Libro(String titolo, String isbn, Float prezzo) {
		this.titolo = titolo;
		this.isbn = isbn;
		this.prezzo = prezzo;
	}
	
	public Libro(String titolo, String isbn, Float prezzo, Autore autore) {
		this.titolo = titolo;
		this.isbn = isbn;
		this.prezzo = prezzo;
		this.autore = autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	@Override
	public int hashCode() {
		return this.isbn.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Libro that = (Libro)obj;
		return this.getIsbn().equals(that.getIsbn());
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo 
				+ ", isbn=" + isbn 
				+ ", autore=" + autore + "]";
	}
	
	

}