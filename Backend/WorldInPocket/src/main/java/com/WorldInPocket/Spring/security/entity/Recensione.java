package com.WorldInPocket.Spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recensioni")
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long destinazioneId;
    @ManyToOne
    @JoinColumn(name = "alloggio_id")
    private Alloggio alloggio;

    public Alloggio getAlloggio() {
		return alloggio;
	}

	public void setAlloggio(Alloggio alloggio) {
		this.alloggio = alloggio;
	}

	private String commento;
    private int punteggio;
    
	public Long getDestinazioneId() {
		return destinazioneId;
	}
	
	public void setDestinazioneId(Long destinazioneId) {
		this.destinazioneId = destinazioneId;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}
    
    
}
