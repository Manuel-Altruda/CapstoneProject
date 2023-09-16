package com.WorldInPocket.Spring.security.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Volo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String compagniaAerea;
    private String numeroVolo;
    private String destinazione;
    private String descrizione;
    private Date dataPartenza;
    private Date dataArrivo;
    private int numeroPasseggeri;
    private double prezzo;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompagniaAerea() {
		return compagniaAerea;
	}
	
	public void setCompagniaAerea(String compagniaAerea) {
		this.compagniaAerea = compagniaAerea;
	}
	
	public String getDestinazione() {
		return destinazione;
	}
	
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	
	public Date getDataPartenza() {
		return dataPartenza;
	}
	
	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	
	public Date getDataArrivo() {
		return dataArrivo;
	}
	
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	
	public int getNumeroPasseggeri() {
		return numeroPasseggeri;
	}
	
	public void setNumeroPasseggeri(int numeroPasseggeri) {
		this.numeroPasseggeri = numeroPasseggeri;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNumeroVolo() {
		return numeroVolo;
	}

	public void setNumeroVolo(String numeroVolo) {
		this.numeroVolo = numeroVolo;
	}

	
	
    
    
}
