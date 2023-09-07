package com.WorldInPocket.Spring.security.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prenotazione_alloggio")
public class PrenotazioneAlloggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String utenteEmail;
	private int numeroPersone;
	@ManyToOne
	@JoinColumn(name = "alloggio_id") 
	private Alloggio alloggio;
    @Column(name = "tipo_alloggio")
    private String tipoAlloggio;
    @ManyToOne
    @JoinColumn(name = "destinazione_id")
    private Destinazione destinazione;    
    @Column(name = "data_check_in")
    private Date dataCheckIn;   
    private Date dataCheckOut;
	
    
    
	public String getTipoAlloggio() {
		return tipoAlloggio;
	}

	public void setTipoAlloggio(String tipoAlloggio) {
		this.tipoAlloggio = tipoAlloggio;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(int numeroPersone) {
	    this.numeroPersone = numeroPersone;
	}
    

	public Destinazione getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(Destinazione destinazione) {
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

	public String getUtenteEmail() {
		return utenteEmail;
	}

	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

}
