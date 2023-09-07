package com.WorldInPocket.Spring.security.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Volo;

@Service
public class VoloService {
	
	public List<Volo> cercaVoli(String destinazione, Date dataCheckIn, Date dataCheckOut,
			int numeroPasseggeri, double budget) {
        
        List<Volo> risultatiRicerca = new ArrayList<>();
        
        Volo volo1 = new Volo();
        volo1.setId(1L);
        volo1.setCompagniaAerea("Airline A");
        volo1.setDestinazione("New York");
        Calendar departureDate = Calendar.getInstance();
        volo1.setDataPartenza(departureDate.getTime());

        volo1.setDataArrivo(departureDate.getTime());
        volo1.setNumeroPasseggeri(500);
        volo1.setPrezzo(800.0);
        risultatiRicerca.add(volo1);

        // Aggiungi altri dati di esempio...

        return risultatiRicerca;
    }
	
}
