package com.WorldInPocket.Spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itinerario_mete")
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descrizione;
    private int durata;
    private int durataLessThan1;
    @ManyToOne 
    @JoinColumn(name = "destinazione_id")
    private Destinazione destinazione;

    
	public Destinazione getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(Destinazione destinazione) {
		this.destinazione = destinazione;
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

	public int getDurataLessThan1() {
		return durataLessThan1;
	}

	public void setDurataLessThan1(int durataLessThan1) {
		this.durataLessThan1 = durataLessThan1;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
    
    
}
