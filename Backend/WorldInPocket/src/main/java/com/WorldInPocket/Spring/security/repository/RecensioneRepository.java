package com.WorldInPocket.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.Recensione;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
	
    List<Recensione> findByDestinazioneId(Long destinazioneId);
    
    List<Recensione> findByHotelId(Long HotelId);
    
}
