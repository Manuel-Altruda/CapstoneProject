package com.WorldInPocket.Spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Recensione;
import com.WorldInPocket.Spring.security.repository.RecensioneRepository;

@Service
public class RecensioneService {
	
	@Autowired
    private RecensioneRepository recensioneRepository;

    public Recensione createRecensione(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public Recensione getRecensioneById(Long id) {
        return recensioneRepository.findById(id).orElse(null);
    }
    
    public List<Recensione> getRecensioniByAlloggio(Long hotelId) {
        return recensioneRepository.findByHotelId(hotelId);
    }
    
    public Recensione updateRecensione(Long recensioneId, Recensione nuovaRecensione) {
        Recensione recensioneEsistente = getRecensioneById(recensioneId);
        if (recensioneEsistente != null) {
            recensioneEsistente.setCommento(nuovaRecensione.getCommento());
            recensioneEsistente.setAlloggio(nuovaRecensione.getAlloggio());
 
            return recensioneRepository.save(recensioneEsistente);
        }
        return null; // Restituisci null se la recensione non esiste
    }
    
}
