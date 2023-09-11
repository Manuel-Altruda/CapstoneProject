package com.WorldInPocket.Spring.security.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;
import com.WorldInPocket.Spring.security.entity.Recensione;

public interface AlloggioRepository extends JpaRepository<Alloggio, Long> {
	
//	List<Alloggio> findAll();
//
//	Optional<Alloggio> findById(Long id);
//	
//	List<Alloggio> findByDestinazione(String destinazione);
//
//	List<Alloggio> findByTipo(String tipo);
//
//	List<Recensione> findRecensioniByAlloggioId(Long alloggioId);
//
//	List<PrenotazioneAlloggio> findPrenotazioniByUtenteId(Long utenteId);
//
//	List<PrenotazioneAlloggio> findPrenotazioniByAlloggioId(Long alloggioId);

//	@Query("SELECT a.destinazione, COUNT(pa.id) AS numPrenotazioni FROM Alloggio a LEFT JOIN a.prenotazioni pa GROUP BY a.destinazione ORDER BY numPrenotazioni DESC")
//	List<Object[]> findDestinazioniPopolari();

}
