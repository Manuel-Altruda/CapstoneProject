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
        return destinazioneRepository.findTop10ByOrderByPopolaritaDesc();
    }

    public List<Destinazione> ricercaDestinazioniPerPrezzo(double prezzoMassimo) {
        return destinazioneRepository.findByPrezzoMedioPerNotteLessThan(prezzoMassimo);
    }

    public Destinazione createDestinazione(Destinazione destinazione) {
        return destinazioneRepository.save(destinazione);
    }

    public Destinazione updateDestinazione(Long id, Destinazione destinazione) {
        Destinazione existingDestinazione = destinazioneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Destinazione non trovata con ID: " + id));

        existingDestinazione.setNome(destinazione.getNome());
        existingDestinazione.setDescrizione(destinazione.getDescrizione());
        existingDestinazione.setImmagine(destinazione.getImmagine());
        return destinazioneRepository.save(existingDestinazione);
    }

    public void deleteDestinazione(Long id) {
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

}

