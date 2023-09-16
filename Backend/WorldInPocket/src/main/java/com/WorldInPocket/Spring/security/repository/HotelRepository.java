package com.WorldInPocket.Spring.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	Hotel save (Hotel hotel);
	
	List<Hotel> findAll();
	
	Optional<Hotel> findById(Long id);
	
	void deleteById(Long id);
}
