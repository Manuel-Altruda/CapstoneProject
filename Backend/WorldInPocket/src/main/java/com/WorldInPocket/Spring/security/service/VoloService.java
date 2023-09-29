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
	public VoloService (VoloRepository voloRepository) {
		this.voloRepository = voloRepository;
	}
	
//	public void generateAndInsertRandomFlights(int numberOfFlights) {
//        Random random = new Random();
//
//        for (int i = 0; i < numberOfFlights; i++) {
//            Volo volo = new Volo();
//            volo.setCompagniaAerea("Airline " + (i + 1));
//            volo.setDestinazione("Destinazione " + (i + 1));
//            // Genera date casuali per dataPartenza e dataArrivo
//            long minDate = System.currentTimeMillis();
//            long maxDate = minDate + (365 * 24 * 60 * 60 * 1000); // Aggiungi un anno
//            long randomDate = minDate + random.nextInt((int) (maxDate - minDate));
//            volo.setDataPartenza(new Date(randomDate));
//            volo.setDataArrivo(new Date(randomDate + random.nextInt(7) * 24 * 3600 * 1000)); // Aggiungi giorni casuali
//            volo.setNumeroPasseggeri(random.nextInt(500));
//            volo.setPrezzo(500 + random.nextDouble() * 500); // Prezzo casuale tra 500 e 1000
//
//            voloRepository.save(volo);
//        }
//    }
	
	
	
	public List<Volo> cercaVoli(String destinazione, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroPasseggeri,
            double prezzo) {
		
		return voloRepository.findByDestinazioneAndDataCheckInGreaterThanEqualAndDataCheckOutLessThanEqualAndNumeroPasseggeriLessThanEqualAndPrezzoLessThanEqual(
				destinazione, dataCheckIn, dataCheckOut, numeroPasseggeri, prezzo);
				
		
	}
//	List<Volo> risultatiRicerca = voloRepository.findByDestinazioneAndDataPartenzaBetween(
//	        destinazione, dataCheckIn, dataCheckOut);
//	Random random = new Random();
//	
//	for (int i = 0; i < 30; i++) {
//		Volo volo = new Volo();
//		volo.setCompagniaAerea("Airline " + (i + 1));
//		volo.setDestinazione(destinazione);
//		long minDate = dataCheckIn.getTime();
//		long maxDate = dataCheckOut.getTime();
//		long randomDate = minDate + random.nextLong() % (maxDate - minDate);
//		volo.setDataPartenza(new Date(randomDate));
//		volo.setDataArrivo(new Date(randomDate + random.nextInt(7) * 24 * 3600 * 1000)); 
//		volo.setNumeroPasseggeri(random.nextInt(500));
//		volo.setPrezzo(500 + random.nextDouble() * 500); 
//		risultatiRicerca.add(volo);
//	}
//	
//	
//	
//	return risultatiRicerca;
//	}
}
