package com.WorldInPocket.Spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "destinazione")
public class Destinazione {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descrizione;
    private double prezzoMassimo;
    private double prezzoMedioPerNotte;
    private String immagine;
    private int popolarita;
    private double valutazioneMedia;
    private String paese;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public int getPopolarita() {
		return popolarita;
	}
	
	public void setPopolarita(int popolarita) {
		this.popolarita = popolarita;
		
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public double getPrezzoMassimo() {
		return prezzoMassimo;
	}

	public void setPrezzoMassimo(double prezzoMassimo) {
		this.prezzoMassimo = prezzoMassimo;
	}

	public double getValutazioneMedia() {
		return valutazioneMedia;
	}

	public void setValutazioneMedia(double valutazioneMedia) {
		this.valutazioneMedia = valutazioneMedia;
	}

	public double getPrezzoMedioPerNotte() {
		return prezzoMedioPerNotte;
	}

	public void setPrezzoMedioPerNotte(double prezzoMedioPerNotte) {
		this.prezzoMedioPerNotte = prezzoMedioPerNotte;
	}
    
}

