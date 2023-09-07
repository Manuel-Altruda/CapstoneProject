package com.WorldInPocket.Spring.security.Request;

import java.util.Date;

public class RicercaAlloggiRequest {
	
	private String destinazione;
    private Date dataCheckIn;
    private Date dataCheckOut;
    private int numeroPersone;
    private double budget;
    
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
	
	public int getNumeroPersone() {
		return numeroPersone;
	}
	
	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
	
	public double getBudget() {
		return budget;
	}
	
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
    
}
