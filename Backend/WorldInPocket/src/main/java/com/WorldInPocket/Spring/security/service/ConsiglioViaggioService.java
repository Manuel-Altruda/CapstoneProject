package com.WorldInPocket.Spring.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.ConsiglioViaggio;
import com.WorldInPocket.Spring.security.repository.ConsiglioViaggioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsiglioViaggioService {

    @Autowired
    private ConsiglioViaggioRepository consiglioViaggioRepository;

    public List<ConsiglioViaggio> getConsigliViaggioAutore(String autore) throws Exception {
        List<ConsiglioViaggio> consigliViaggio = consiglioViaggioRepository.findByAutore(autore);

        if (consigliViaggio.isEmpty()) {
            throw new Exception("Nessun consiglio di viaggio trovato per l'autore: " + autore);
        }

        return consigliViaggio;
    }
    public ConsiglioViaggio createConsiglioViaggio(ConsiglioViaggio consiglioViaggio) {
        // Implementa la logica per creare un nuovo consiglio di viaggio
        return (ConsiglioViaggio) consiglioViaggioRepository.save(consiglioViaggio);
    }

    public List<ConsiglioViaggio> updateConsiglioViaggio(Long id, ConsiglioViaggio consiglioViaggio) {
        Optional<ConsiglioViaggio> optionalConsiglioViaggio = consiglioViaggioRepository.findById(id);

        if (optionalConsiglioViaggio.isPresent()) {
            ConsiglioViaggio existingConsiglioViaggio = optionalConsiglioViaggio.get();

            existingConsiglioViaggio.setAutore(consiglioViaggio.getAutore());
            existingConsiglioViaggio.setTitolo(consiglioViaggio.getTitolo());
            existingConsiglioViaggio.setTesto(consiglioViaggio.getTesto());

            return (List<ConsiglioViaggio>) consiglioViaggioRepository.save(existingConsiglioViaggio);
        } else {
           
            throw new EntityNotFoundException("Consiglio di viaggio non trovato con ID: " + id);
        }
    }

    public void deleteConsiglioViaggio(Long id) {
        Optional<ConsiglioViaggio> optionalConsiglioViaggio = consiglioViaggioRepository.findById(id);

        if (optionalConsiglioViaggio.isPresent()) {
            // Se il ConsiglioViaggio esiste, ottieni l'istanza e elimina
            ConsiglioViaggio consiglioViaggio = optionalConsiglioViaggio.get();
            consiglioViaggioRepository.delete(consiglioViaggio);
        } else {
            
            throw new EntityNotFoundException("Consiglio di viaggio non trovato con ID: " + id);
        }
    }
    
	public List<ConsiglioViaggio> getAllConsigliViaggio() {
        return consiglioViaggioRepository.findAll();

	}
	
	public ConsiglioViaggio getConsiglioViaggioById(Long id) {
        Optional<ConsiglioViaggio> optionalConsiglioViaggio = consiglioViaggioRepository.findById(id);

        if (optionalConsiglioViaggio.isPresent()) {
            return optionalConsiglioViaggio.get();
        } else {
            
            throw new EntityNotFoundException("Travel tip not found with ID: " + id);
        }
    }
	
	public void deleteConsiglioViaggio(ConsiglioViaggio consiglioViaggio) {
	    consiglioViaggioRepository.delete(consiglioViaggio);
	}

	public void deleteConsigliViaggio(List<ConsiglioViaggio> consigliViaggio) {
	    consiglioViaggioRepository.deleteAll(consigliViaggio);
	}
	
}

