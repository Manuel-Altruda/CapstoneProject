package com.WorldInPocket.Spring.security.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Volo;
import com.WorldInPocket.Spring.security.repository.VoloRepository;

@Service
public class VoloService {

	private VoloRepository voloRepository;
	
	
	@Autowired
    public VoloService(VoloRepository voloRepository) {
        this.voloRepository = voloRepository;
    }

	public List<Volo> cercaVoli(String origin, String destinazione, LocalDate dataCheckIn, LocalDate dataCheckOut,
			int numeroPasseggeri) {
		
		return voloRepository.findByOriginAndDestinazioneAndDataCheckInGreaterThanEqualAndDataCheckOutLessThanEqualAndNumeroPasseggeriLessThanEqual(
				origin, destinazione, dataCheckIn, dataCheckOut, numeroPasseggeri);
	}
	
	 public Volo getVoloById(Long id) {
	        return voloRepository.findById(id).orElse(null);
	   }

}

