package com.WordInPocket.Spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WordInPocket.Spring.security.entity.Destinazione;
import com.WordInPocket.Spring.security.entity.Itinerario;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {

	List<Itinerario> findByNomeContaining(String keyword);
	
	List<Itinerario> findByDestinazione(Destinazione destinazione);

	List<Itinerario> findByDurataLessThan(int durataMassima);

	List<Itinerario> findByDestinazioneAndDurataLessThan(Destinazione destinazione, int durataMassima);

	List<Itinerario> findByNome(String nome);

	List<Itinerario> findByDescrizioneContaining(String keyword);

	List<Itinerario> findByDurataLessThan1(int durata);

}
