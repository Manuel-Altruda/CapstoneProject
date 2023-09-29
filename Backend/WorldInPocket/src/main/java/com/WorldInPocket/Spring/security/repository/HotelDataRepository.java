package com.WorldInPocket.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.HotelData;

public interface HotelDataRepository extends JpaRepository<HotelData, Long>{

	 HotelData save(HotelData hotelData);

}
