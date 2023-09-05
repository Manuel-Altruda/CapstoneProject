package com.WordInPocket.Spring.security.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PrenotazioneAlloggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAlloggio;
    private Date dataCheckIn;
    private Date dataCheckOut;
    
    
	public String getNomeAlloggio() {
		return nomeAlloggio;
	}
	
	public void setNomeAlloggio(String nomeAlloggio) {
		this.nomeAlloggio = nomeAlloggio;
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
}
