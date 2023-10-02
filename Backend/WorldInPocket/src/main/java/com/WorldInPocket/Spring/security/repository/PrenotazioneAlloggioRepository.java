package com.WorldInPocket.Spring.security.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.WorldInPocket.Spring.security.Request.PrenotazioneAlloggioRequest;

//import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.Destinazione;
import com.WorldInPocket.Spring.security.entity.Hotel;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;

public interface PrenotazioneAlloggioRepository extends JpaRepository<PrenotazioneAlloggio, Long> {

	List<PrenotazioneAlloggio> findByHotelNameContaining(String name);
	
	List<PrenotazioneAlloggio> findByHotel(Hotel hotel);
	
	@Query("SELECT pa FROM PrenotazioneAlloggio pa WHERE pa.dataCheckIn = :dataCheck")
	List<PrenotazioneAlloggio> findByDataCheck(@Param("dataCheck") Date dataCheck);
	
	List<PrenotazioneAlloggio> findByDestinazioneAndTipoHotelAndDataCheckInBetween(Destinazione destinazione, String tipoHotel, Date checkIn, Date checkOut);
	
	List<PrenotazioneAlloggio> findByTipoHotel(String tipoHotel);

	List<PrenotazioneAlloggio> findByUtenteEmail(String emailUtente);

	List<PrenotazioneAlloggio> findByDataCheckOut(Date dataCheckOut);

	//List<PrenotazioneAlloggio> save(PrenotazioneAlloggioRequest prenotazioneAlloggioRequest);
	
}
