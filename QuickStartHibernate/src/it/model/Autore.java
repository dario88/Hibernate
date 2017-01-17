package it.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Autore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	@OneToMany(mappedBy="autore")
	private List<Libro> libri;
	
	
	public Autore() {
		
	}
	
	public Autore(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.libri = new LinkedList<Libro>();
	}
	
	public Autore(String nome, String cognome, Date dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.libri = new LinkedList<Libro>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode() + this.cognome.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Autore that = (Autore)obj;
		if (this.getCognome().equals(that.getCognome()))
			return this.getNome().equals(that.getNome());
		return this.getCognome().equals(that.getCognome());
	}

	@Override
	public String toString() {
		return "Autore [nome=" + nome 
				+ ", cognome=" + cognome 
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}
	

}
