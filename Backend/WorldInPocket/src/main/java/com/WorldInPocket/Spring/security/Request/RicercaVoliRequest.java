package com.WorldInPocket.Spring.security.Request;

import java.util.Date;

public class RicercaVoliRequest {
	
	private String destinazione;
    private Date dataPartenza;
    private int numeroPersone;
    
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
	
	public int getNumeroPersone() {
		return numeroPersone;
	}
	
	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
	
}
