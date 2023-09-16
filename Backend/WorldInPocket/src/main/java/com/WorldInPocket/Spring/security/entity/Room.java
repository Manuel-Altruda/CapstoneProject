package com.WorldInPocket.Spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroStanza;
	private String tipoStanza;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroStanza() {
		return numeroStanza;
	}

	public void setNumeroStanza(String numeroStanza) {
		this.numeroStanza = numeroStanza;
	}

	public String getTipoStanza() {
		return tipoStanza;
	}

	public void setTipoStanza(String tipoStanza) {
		this.tipoStanza = tipoStanza;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
}
