package com.WorldInPocket.Spring.security.entity;

import java.time.LocalDate;
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
	private final String origin;
    private String compagniaAerea;
    private String numeroVolo;
    private String destinazione;
    private String descrizione;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int numeroPasseggeri;
    private double prezzo;
    
    
    public Volo(String origin, String compagniaAerea, String numeroVolo, String destinazione, String descrizione, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroPasseggeri, double prezzo) {
        this.origin = origin;
        this.compagniaAerea = compagniaAerea;
        this.numeroVolo = numeroVolo;
        this.destinazione = destinazione;
        this.descrizione = descrizione;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPasseggeri = numeroPasseggeri;
        this.prezzo = prezzo;
    }
    
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
	
	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}
	
	public void setDataCheckIn(LocalDate dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	
	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}
	
	public void setDataCheckOut(LocalDate dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
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

	public String getOrigin() {
		return origin;
	}
	
    
}
