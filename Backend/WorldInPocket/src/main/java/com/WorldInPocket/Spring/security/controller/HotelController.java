package com.WorldInPocket.Spring.security.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.Hotel;
import com.WorldInPocket.Spring.security.repository.HotelRepository;
import com.WorldInPocket.Spring.security.service.HotelService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/hotels")
public class HotelController {
	
	@Autowired
    private HotelService hotelService;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@PostMapping
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
        try {
            Hotel createdHotel = hotelService.createHotel(hotel);
            return ResponseEntity.ok(createdHotel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create hotel.");
        }
    }
	
	@GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateHotel(@PathVariable Long id, @RequestBody Hotel updatedHotel) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        hotelRepository.save(hotel);
        return ResponseEntity.ok("Hotel aggiornato con successo.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        hotelRepository.delete(hotel);
        return ResponseEntity.ok("Hotel eliminato con successo.");
    }
    
    @PostMapping("/hotelJson")
    public ResponseEntity<String> receiveJsonData(@RequestBody List<Hotel> hotels) {
      try {
        for (Hotel hotel : hotels) {
          hotelRepository.save(hotel); // Salva ogni hotel nel database
        }
        return ResponseEntity.ok("Dati inseriti con successo nel database.");
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante l'inserimento dei dati nel database.");
      }
    }
    
}
