package com.WorldInPocket.Spring.security.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.AzioneUtente;
import com.WorldInPocket.Spring.security.entity.Destinazione;
import com.WorldInPocket.Spring.security.entity.Recensione;
import com.WorldInPocket.Spring.security.entity.Visita;
import com.WorldInPocket.Spring.security.repository.AzioneUtenteRepository;
import com.WorldInPocket.Spring.security.repository.DestinazioneRepository;
import com.WorldInPocket.Spring.security.repository.RecensioneRepository;
import com.WorldInPocket.Spring.security.repository.VisitaRepository;

@Service
public class PopolaritaService {

	@Autowired
    private DestinazioneRepository destinazioneRepository;

    @Autowired
    private RecensioneRepository recensioneRepository;

    @Autowired
    private VisitaRepository visitaRepository;

    @Autowired
    private AzioneUtenteRepository azioneUtenteRepository; 

    public void calcolaPopolaritaDestinazioni() {
        List<Destinazione> destinazioni = destinazioneRepository.findAll();

        for (Destinazione destinazione : destinazioni) {
        	
            // Calcola la popolarità per ciascuna destinazione
            int popolarita = calcolaPopolarita(destinazione.getId());
            destinazione.setPopolarita(popolarita);
            destinazioneRepository.save(destinazione);
        }
    }

    private int calcolaPopolarita(Long destinazioneId) {
    	
        // Calcola la popolarità in base alle recensioni e alle visite per la destinazione specifica
        List<Recensione> recensioni = recensioneRepository.findByDestinazioneId(destinazioneId);
        List<Visita> visite = visitaRepository.findByDestinazioneId(destinazioneId);
        List<AzioneUtente> azioniUtente = azioneUtenteRepository.findByOggettoId(destinazioneId);

        // Esempio di calcolo di popolarità 
        int popolarita = azioniUtente.size() + recensioni.size() * 2 + visite.size();
        return popolarita;
    }
}

