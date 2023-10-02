package com.WorldInPocket.Spring.security.entity;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;

import jakarta.annotation.Nullable;
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
    
    @Column(name = "numero_persone")
	private int numeroPersone;
	  
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
    @Column(name = "tipo_hotel")
    private String tipoHotel;
    
    @ManyToOne
    @JoinColumn(name = "destinazione_id")
    private Destinazione destinazione;    
    
    @Column(name = "data_check_in")
    private Date dataCheckIn;   
    
    @Column(name = "data_check_out")
    private Date dataCheckOut;
    
  
    private double prezzoPerNotte;
    @ManyToOne
	private Iricevuta iricevuta;
	
    public double calcolaPrezzo() {
        if (hotel == null || dataCheckIn == null || dataCheckOut == null || prezzoPerNotte <= 0 || numeroPersone <= 0) {
            throw new IllegalArgumentException("Dati insufficienti per calcolare il prezzo");
        }
        
        long giorniPrenotazione = (dataCheckOut.getTime() - dataCheckIn.getTime()) / (24 * 60 * 60 * 1000);
        if (giorniPrenotazione <= 0) {
            throw new IllegalArgumentException("Date di check-in o check-out non valide");
        }
        double prezzoBase = prezzoPerNotte * giorniPrenotazione;
       // double sconto = calcolaSconto(); 
        double tassa = calcolaTassa(); 
        double prezzoTotale = prezzoBase + tassa;

        return prezzoTotale;
    }
    
    public void setIricevuta(Iricevuta iricevuta) {
        if (iricevuta != null) {
            this.iricevuta = iricevuta;
        } else {
            throw new DataIntegrityViolationException("Specifica la ricevuta.");
        }
    }
    
//    private double calcolaSconto() {
//        boolean isMembroPremium = checkMembroPremium();       
//        if (isMembroPremium) {
//            double sconto = 0.10 * prezzoPerNotte * numeroPersone * getNumeroNotti();
//            return sconto;
//        } else {
//            return 0.0;
//        }
//    }

    private long getNumeroNotti() {
        if (dataCheckIn == null || dataCheckOut == null) {
            throw new IllegalArgumentException("Date di check-in o check-out non valide");
        }
        long giorniPrenotazione = (dataCheckOut.getTime() - dataCheckIn.getTime()) / (24 * 60 * 60 * 1000);        
        if (giorniPrenotazione <= 0) {
            throw new IllegalArgumentException("Date di check-in o check-out non valide");
        }
        
        return giorniPrenotazione;
    }
  
    private double calcolaTassa() {
        double percentualeTassa = 0.05;
        double prezzoAlloggio = prezzoPerNotte * numeroPersone * getNumeroNotti();
        double tassa = percentualeTassa * prezzoAlloggio;
        
        return tassa;
    }
    
    
	public String getTipoHotel() {
		return tipoHotel;
	}

	public void setTipoHotel(String tipoHotel) {
		this.tipoHotel = tipoHotel;
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

	public double getPrezzoPerNotte() {
		return prezzoPerNotte;
	}

	public void setPrezzoPerNotte(double prezzoPerNotte) {
		this.prezzoPerNotte = prezzoPerNotte;
	}


}
