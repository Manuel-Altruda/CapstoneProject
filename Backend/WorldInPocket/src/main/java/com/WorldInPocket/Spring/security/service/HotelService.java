package com.WorldInPocket.Spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Hotel;
import com.WorldInPocket.Spring.security.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        Hotel hotel1 = convertToHotel(hotel);
        return hotelRepository.save(hotel1);
    }

    private Hotel convertToHotel(Hotel hotel) {
        Hotel hotel1 = new Hotel();
        hotel1.setName(hotel.getName());
        
        return hotel1;
    }

    public Double getHotelPrice(Long hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            return hotel.getPrezzo();
        } else {
            return null;
        }
    }
}
