package com.WorldInPocket.Spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.Destinazione;

public interface DestinazioneRepository extends JpaRepository<Destinazione, Long> {

	List<Destinazione> findByValutazioneMediaGreaterThanAndPrezzoMassimoLessThan(double valutazione, double prezzo);

	List<Destinazione> findByNome(String nome);

	List<Destinazione> findByDescrizioneContaining(String keyword);

	List<Destinazione> findByValutazioneMediaGreaterThan(double valutazioneMedia);

	List<Destinazione> findByPrezzoMassimoLessThan(double prezzoMassimo);

	List<Destinazione> findByPaese(String paese);

	List<Destinazione> findByNomeContaining(String keyword);
	
	List<Destinazione> findByNomeAndDescrizione(String nome, String descrizione);
	 
	List<Destinazione> findTop10ByOrderByPopolaritaDesc();

	List<Destinazione> findByOrderByPopolaritaDesc();
	
	List<Destinazione> findByPrezzoMedioPerNotteLessThan(double prezzoMedioPerNotte);

	
}
