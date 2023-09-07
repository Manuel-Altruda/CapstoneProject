package com.WorldInPocket.Spring.security.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.WorldInPocket.Spring.security.entity.Alloggio;
//import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.Destinazione;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;

public interface PrenotazioneAlloggioRepository extends JpaRepository<PrenotazioneAlloggio, Long> {

	List<PrenotazioneAlloggio> findByAlloggioNomeContaining(String keyword);
	
	List<PrenotazioneAlloggio> findByAlloggioNome(String nome);
	
	@Query("SELECT pa FROM PrenotazioneAlloggio pa WHERE pa.dataCheckIn = :dataCheck")
	List<PrenotazioneAlloggio> findByDataCheck(@Param("dataCheck") Date dataCheck);
	
	List<PrenotazioneAlloggio> findByDestinazioneAndTipoAlloggioAndDataCheckInBetween(Destinazione destinazione, String tipoAlloggio, Date checkIn, Date checkOut);
	
	List<PrenotazioneAlloggio> findByTipoAlloggio(String tipoAlloggio);

	List<PrenotazioneAlloggio> findByUtenteEmail(String emailUtente);

	List<PrenotazioneAlloggio> findByDataCheckOut(Date dataCheckOut);

	List<PrenotazioneAlloggio> findByAlloggio(Alloggio alloggio);
}
