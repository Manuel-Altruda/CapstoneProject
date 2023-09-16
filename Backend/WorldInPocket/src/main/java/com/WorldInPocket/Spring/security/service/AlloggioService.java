package com.WorldInPocket.Spring.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.repository.AlloggioRepository;

@Service
public class AlloggioService {
	
	@Autowired
    private AlloggioRepository alloggioRepository;

	
    public List<Alloggio> cercaAlloggi(String destinazione, Date dataCheckIn, Date dataCheckOut, int numeroPersone, double budget) {
        List<Alloggio> risultatiRicerca = new ArrayList<>();
        
        Alloggio alloggio1 = new Alloggio();
        alloggio1.setId(1L);
        alloggio1.setNome("Hotel Bella Vista");
        alloggio1.setDestinazione("Roma");
        alloggio1.setDataCheckIn(new Date());
        alloggio1.setDataCheckOut(new Date());
        alloggio1.setNumeroPersone(2);
        alloggio1.setPrezzoPerNotte(100.0);
        risultatiRicerca.add(alloggio1);

        return risultatiRicerca;
    }
    
    public List<Alloggio> getAlloggi() {
        return alloggioRepository.findAll();
    }

    public Alloggio getAlloggioById(Long id) {
        return alloggioRepository.findById(id).orElse(null);
    }

    public Alloggio createAlloggio(Alloggio alloggio) {
        return alloggioRepository.save(alloggio);
    }

    public Alloggio updateAlloggio(Long id, Alloggio nuovaAlloggio) {
        Alloggio alloggioEsistente = alloggioRepository.findById(id).orElse(null);
        if (alloggioEsistente != null) {
            alloggioEsistente.setNome(nuovaAlloggio.getNome());
            alloggioEsistente.setNome(nuovaAlloggio.getNome());
            return alloggioRepository.save(alloggioEsistente);
        }
        return null;
    }

    public boolean deleteAlloggio(Long id) {
        if (alloggioRepository.existsById(id)) {
            alloggioRepository.deleteById(id);
            return true;
        }
        return false; 
    }
}
