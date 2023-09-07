package com.WorldInPocket.Spring.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Destinazione;
import com.WorldInPocket.Spring.security.entity.Itinerario;
import com.WorldInPocket.Spring.security.repository.ItinerarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItinerarioService {

    @Autowired
    private ItinerarioRepository itinerarioRepository;

    public List<Itinerario> getItinerariPerDestinazione(Destinazione destinazione) {
        return itinerarioRepository.findByDestinazione(destinazione);
    }

    public List<Itinerario> ricercaItinerariPerDurataMassima(int durataMassima) {
        return itinerarioRepository.findByDurataLessThan(durataMassima);
    }

    public Itinerario createItinerario(Itinerario itinerario) {
        return itinerarioRepository.save(itinerario);
    }

    public Itinerario updateItinerario(Long id, Itinerario itinerario) {
        Itinerario existingItinerario = itinerarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Itinerario non trovato con ID: " + id));
        return itinerarioRepository.save(existingItinerario);
    }

    public void deleteItinerario(Long id) {
        Itinerario itinerario = itinerarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Itinerario non trovato con ID: " + id));
        itinerarioRepository.delete(itinerario);
    }

	public List<Itinerario> getAllItinerari() {
		return itinerarioRepository.findAll();
	}

	public Itinerario getItinerarioById(Long id) {
        // Use the Spring Data JPA repository to retrieve an itinerary by its ID
        Optional<Itinerario> optionalItinerario = itinerarioRepository.findById(id);

        if (optionalItinerario.isPresent()) {
            return optionalItinerario.get();
        } else {
            // Handle the case where the itinerary with the given ID is not found
            // You can throw an exception or handle it according to your application's requirements
            throw new EntityNotFoundException("Itinerary not found with ID: " + id);
        }
    }

    // Altri metodi di business relativi agli itinerari
}

