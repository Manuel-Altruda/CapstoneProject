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
	private String origin;
    private String compagniaAerea;
    private String numeroVolo;
    private String destinazione;
    private String descrizione;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int numeroPasseggeri;
    private double prezzo;
    
    
    @Override
    public String toString() {
        return "Volo{" +
                "  origin='" + origin + '\'' +
                ", compagniaAerea='" + compagniaAerea + '\'' +
                ", numeroVolo='" + numeroVolo + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataCheckIn=" + dataCheckIn +
                ", dataCheckOut=" + dataCheckOut +
                ", numeroPasseggeri=" + numeroPasseggeri +
                ", prezzo=" + prezzo +
                '}';
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
	
	public void setDataCheckIn(LocalDate date) {
		this.dataCheckIn = date;
	}
	
	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}
	
	public void setDataCheckOut(LocalDate date) {
		this.dataCheckOut = date;
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

	public String setOrigin(String origin) {
		return this.origin = origin;
	}
	
    
}
