package com.WordInPocket.Spring.security.repository;

import java.util.Date;
import java.util.List;

import com.WordInPocket.Spring.security.entity.Destinazione;
import com.WordInPocket.Spring.security.entity.PrenotazioneVolo;

public interface PrenotazioneVoloRepository {

	List<PrenotazioneVolo> findByCompagniaAerea(String compagniaAerea);

	List<PrenotazioneVolo> findByDataPrenotazioneAfter(Date data);

	List<PrenotazioneVolo> findByDestinazioneAndCompagniaAerea(Destinazione destinazione, String compagniaAerea);

	List<PrenotazioneVolo> findByDestinazioneAndData(Destinazione destinazione, Date data);

	List<PrenotazioneVolo> findByDataBetween(Date startDate, Date endDate);
}
