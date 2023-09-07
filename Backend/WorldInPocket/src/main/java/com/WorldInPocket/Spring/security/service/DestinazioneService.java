package com.WorldInPocket.Spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Destinazione;
import com.WorldInPocket.Spring.security.repository.DestinazioneRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DestinazioneService {

    @Autowired
    private DestinazioneRepository destinazioneRepository;

    public List<Destinazione> getDestinazioniPopolari() {
        // Implementa una logica per recuperare le destinazioni più popolari, ad esempio basata su recensioni degli utenti o visite
        return destinazioneRepository.findTop10ByOrderByPopolaritaDesc();
    }

    public List<Destinazione> ricercaDestinazioniPerPrezzo(double prezzoMassimo) {
        // Implementa una logica per cercare destinazioni con un prezzo al di sotto di un certo limite
        return destinazioneRepository.findByPrezzoMedioPerNotteLessThan(prezzoMassimo);
    }

    public Destinazione createDestinazione(Destinazione destinazione) {
        // Implementa la logica per creare una nuova destinazione, ad esempio la validazione dei dati
        return destinazioneRepository.save(destinazione);
    }

    public Destinazione updateDestinazione(Long id, Destinazione destinazione) {
        // Implementa la logica per aggiornare una destinazione esistente, ad esempio la gestione dei campi modificabili
        Destinazione existingDestinazione = destinazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Destinazione non trovata con ID: " + id));

        existingDestinazione.setNome(destinazione.getNome());
        existingDestinazione.setDescrizione(destinazione.getDescrizione());
        existingDestinazione.setImmagine(destinazione.getImmagine());
        return destinazioneRepository.save(existingDestinazione);
    }

    public void deleteDestinazione(Long id) {
        // Implementa la logica per eliminare una destinazione
        Destinazione destinazione = destinazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Destinazione non trovata con ID: " + id));
        destinazioneRepository.delete(destinazione);
    }

	public Destinazione getDestinazioneById(Long id) {
		return destinazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Destinazione not found with ID: " + id));
	}

	public List<Destinazione> getAllDestinazioni() {
		 return destinazioneRepository.findAll();
	}

    // Altri metodi di business relativi alle destinazioni
}

