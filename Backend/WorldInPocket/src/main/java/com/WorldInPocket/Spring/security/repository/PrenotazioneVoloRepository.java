package com.WorldInPocket.Spring.security.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.Destinazione;
import com.WorldInPocket.Spring.security.entity.PrenotazioneVolo;

public interface PrenotazioneVoloRepository extends JpaRepository<PrenotazioneVolo, Long> {

	List<PrenotazioneVolo> findByCompagniaAerea(String compagniaAerea);

	List<PrenotazioneVolo> findByDataPrenotazioneAfter(Date dataPrenotazione);

	List<PrenotazioneVolo> findByDestinazioneAndCompagniaAerea(Destinazione destinazione, String compagniaAerea);

	List<PrenotazioneVolo> findByDestinazioneAndData(Destinazione destinazione, Date data);

	List<PrenotazioneVolo> findByDataPartenzaBetween(Date dataPartenza, Date dataArrivo);

	List<PrenotazioneVolo> findByUtenteEmail(String emailUtente);

	List<PrenotazioneVolo> findByDataPartenza(Date dataPartenza);
}
