package com.WorldInPocket.Spring.security.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.PrenotazioneVolo;
import com.WorldInPocket.Spring.security.repository.PrenotazioneVoloRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PrenotazioneVoloService {

    @Autowired
    private PrenotazioneVoloRepository prenotazioneVoloRepository;

    public List<PrenotazioneVolo> getPrenotazioniVoloUtente(String emailUtente) {
        return prenotazioneVoloRepository.findByUtenteEmail(emailUtente);
    }

    public List<PrenotazioneVolo> ricercaPrenotazioniVoloPerData(Date dataPartenza) {
        return prenotazioneVoloRepository.findByDataPartenza(dataPartenza);
    }

    public PrenotazioneVolo createPrenotazioneVolo(PrenotazioneVolo prenotazioneVolo) {
        return prenotazioneVoloRepository.save(prenotazioneVolo);
    }

    public PrenotazioneVolo updatePrenotazioneVolo(Long id, PrenotazioneVolo prenotazioneVolo) {
        PrenotazioneVolo existingPrenotazioneVolo = prenotazioneVoloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione di volo non trovata con ID: " + id));
        return prenotazioneVoloRepository.save(existingPrenotazioneVolo);
    }

    public void deletePrenotazioneVolo(Long id) {
        PrenotazioneVolo prenotazioneVolo = prenotazioneVoloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione di volo non trovata con ID: " + id));
        prenotazioneVoloRepository.delete(prenotazioneVolo);
    }

	public List<PrenotazioneVolo> getAllPrenotazioniVolo() {
		 return prenotazioneVoloRepository.findAll();
	}

	public PrenotazioneVolo getPrenotazioneVoloById(Long id) {
        Optional<PrenotazioneVolo> optionalPrenotazioneVolo = prenotazioneVoloRepository.findById(id);

        if (optionalPrenotazioneVolo.isPresent()) {
            return optionalPrenotazioneVolo.get();
        } else {
            throw new EntityNotFoundException("Flight reservation not found with ID: " + id);
        }
    }

}
