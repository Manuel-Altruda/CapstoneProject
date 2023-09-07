package com.WorldInPocket.Spring.security.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AzioneUtente")
public class AzioneUtente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId; 
    private String tipoAzione; 
    private Long oggettoId;
    private LocalDateTime dataOra;
    
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTipoAzione() {
		return tipoAzione;
	}

	public void setTipoAzione(String tipoAzione) {
		this.tipoAzione = tipoAzione;
	}

	public Long getOggettoId() {
		return oggettoId;
	}

	public void setOggettoId(Long oggettoId) {
		this.oggettoId = oggettoId;
	}

	public LocalDateTime getDataOra() {
		return dataOra;
	}

	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}

    
}

