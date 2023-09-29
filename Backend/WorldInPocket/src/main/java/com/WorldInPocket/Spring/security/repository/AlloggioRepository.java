package com.WorldInPocket.Spring.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;
import com.WorldInPocket.Spring.security.entity.Recensione;

public interface AlloggioRepository extends JpaRepository<Alloggio, Long> {
	
	List<Alloggio> findAll();

	Optional<Alloggio> findById(Long id);
	
	List<Alloggio> findByDestinazione(String destinazione);

	List<Alloggio> findByTipo(String tipo);

	List<Recensione> findRecensioniByAlloggioId(Long alloggioId);
	
	List<PrenotazioneAlloggio> findPrenotazioniByUtenteId(Long utenteId);

	List<PrenotazioneAlloggio> findPrenotazioniByAlloggioId(Long alloggioId);

}
