package com.WordInPocket.Spring.security.repository;

import java.util.Date;
import java.util.List;

import com.WordInPocket.Spring.security.entity.Destinazione;
import com.WordInPocket.Spring.security.entity.PrenotazioneAlloggio;

public interface PrenotazioneAlloggioRepository {

	List<PrenotazioneAlloggio> findByNomeAlloggioContaining(String keyword);

	List<PrenotazioneAlloggio> findByDataCheckInAfter(Date data);

	List<PrenotazioneAlloggio> findByDestinazioneAndTipoAlloggioAndDateCheckInBetween(Destinazione destinazione, String tipoAlloggio, Date checkIn, Date checkOut);

	List<PrenotazioneAlloggio> findByTipoAlloggio(String tipoAlloggio);

	
}
