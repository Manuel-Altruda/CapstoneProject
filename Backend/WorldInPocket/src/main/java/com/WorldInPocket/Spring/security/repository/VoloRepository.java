package com.WorldInPocket.Spring.security.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldInPocket.Spring.security.entity.Volo;

@Repository
public interface VoloRepository extends JpaRepository<Volo, Long>{
	
	List<Volo> findByDestinazioneAndDataCheckInBetween(String destinazione, Date dataCheckIn, Date dataCheckOut);

	List<Volo> findByOriginAndDestinazioneAndDataCheckInGreaterThanEqualAndDataCheckOutLessThanEqualAndNumeroPasseggeriLessThanEqual(
			String origin, String destinazione, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroPasseggeri );
	
}
