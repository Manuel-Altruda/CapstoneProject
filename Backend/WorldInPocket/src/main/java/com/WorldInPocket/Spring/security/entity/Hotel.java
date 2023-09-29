package com.WorldInPocket.Spring.security.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.data.history.Revision;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String indirizzo;
	private String citta;
	private String stato;
	private String nazione;
	private String descrizione;
	private double prezzoPerNotte;
	private Date checkInData;
	private Date checkOutDate;
	private double rating;
	private double prezzo;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<PrenotazioneAlloggio> prenotazioniAlloggio;
	
	public List<PrenotazioneAlloggio> getPrenotazioniAlloggio() {
        return prenotazioniAlloggio;
    }

    public void setPrenotazioniAlloggio(List<PrenotazioneAlloggio> prenotazioniAlloggio) {
        this.prenotazioniAlloggio = prenotazioniAlloggio;
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getStato() {
		return stato;
	}
	
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public String getNazione() {
		return nazione;
	}
	
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public Long getId() {
		return id;
	}
	
	
	@OneToMany (mappedBy = "hotel", cascade = CascadeType.ALL )
	private List<Room> rooms;
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public double getPrezzoPerNotte() {
		return prezzoPerNotte;
	}

	public void setPrezzoPerNotte(double prezzoPerNotte) {
		this.prezzoPerNotte = prezzoPerNotte;
	}

	public Date getCheckInData() {
		return checkInData;
	}

	public void setCheckInData(Date checkInData) {
		this.checkInData = checkInData;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	
}
