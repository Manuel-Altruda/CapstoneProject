package com.WorldInPocket.Spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;

@Service
public class PrenotazioneService {
    private List<PrenotazioneAlloggio> prenotazioni = new ArrayList<>();

    public void addPrenotazione(PrenotazioneAlloggio prenotazione) {
        prenotazioni.add(prenotazione);
    }

    public List<PrenotazioneAlloggio> getPrenotazioni() {
        return prenotazioni;
    }

    public void reset() {
        prenotazioni.clear();
    }
}
