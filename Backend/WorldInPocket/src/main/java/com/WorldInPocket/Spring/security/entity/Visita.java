package com.WorldInPocket.Spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long destinazioneId;
    
	public Long getDestinazioneId() {
		return destinazioneId;
	}
	
	public void setDestinazioneId(Long destinazioneId) {
		this.destinazioneId = destinazioneId;
	} 
    
}
