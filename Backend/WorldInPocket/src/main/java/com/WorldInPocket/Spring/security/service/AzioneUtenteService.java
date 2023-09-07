package com.WorldInPocket.Spring.security.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.AzioneUtente;
import com.WorldInPocket.Spring.security.repository.AzioneUtenteRepository;

@Service
public class AzioneUtenteService {

    @Autowired
    private AzioneUtenteRepository azioneUtenteRepository;

    public void registraAzioneUtente(Long userId, String tipoAzione, Long oggettoId) {
        AzioneUtente azioneUtente = new AzioneUtente();
        azioneUtente.setUserId(userId);
        azioneUtente.setTipoAzione(tipoAzione);
        azioneUtente.setOggettoId(oggettoId);
        azioneUtente.setDataOra(LocalDateTime.now());

        azioneUtenteRepository.save(azioneUtente);
    }
}

