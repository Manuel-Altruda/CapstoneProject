package com.WorldInPocket.Spring.security.dto;

import java.util.Date;

public class RisultatoRicercaAlloggiDTO {
	
	private Long id;
    private String nome;
    private String descrizione;
    private String destinazione;
    private Date dataCheckIn;
    private Date dataCheckOut;
    private double prezzo;
    private double prezzoPerNotte;
    
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDestinazione() {
		return destinazione;
	}
	
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	
	public Date getDataCheckIn() {
		return dataCheckIn;
	}
	
	public void setDataCheckIn(Date dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	
	public Date getDataCheckOut() {
		return dataCheckOut;
	}
	
	public void setDataCheckOut(Date dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzoPerNotte() {
		return prezzoPerNotte;
	}

	public void setPrezzoPerNotte(double prezzoPerNotte) {
		this.prezzoPerNotte = prezzoPerNotte;
	}
	
}
