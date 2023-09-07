package com.WorldInPocket.Spring.security.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CambioValuta")
public class CambioValuta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String valutaDa;
	private String valutaA;
	private double tassoCambio;
	
	
	public String getValutaDa() {
		return valutaDa;
	}
	
	public void setValutaDa(String valutaDa) {
		this.valutaDa = valutaDa;
	}

	public String getValutaA() {
		return valutaA;
	}

	public void setValutaA(String valutaA) {
		this.valutaA = valutaA;
	}

	public double getTassoCambio() {
		return tassoCambio;
	}

	public void setTassoCambio(double tassoCambio) {
		this.tassoCambio = tassoCambio;
	}
}
