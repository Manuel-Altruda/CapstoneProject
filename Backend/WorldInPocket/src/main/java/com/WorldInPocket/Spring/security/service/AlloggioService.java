package com.WorldInPocket.Spring.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.Alloggio;

@Service
public class AlloggioService {

    public List<Alloggio> cercaAlloggi(String destinazione, Date dataCheckIn, Date dataCheckOut, int numeroPersone, double budget) {
        // Simula una ricerca di alloggi restituendo dati di esempio
        List<Alloggio> risultatiRicerca = new ArrayList<>();
        // Aggiungi dati di esempio
        Alloggio alloggio1 = new Alloggio();
        alloggio1.setId(1L);
        alloggio1.setNome("Hotel Bella Vista");
        alloggio1.setDestinazione("Roma");
        alloggio1.setDataCheckIn(new Date());
        alloggio1.setDataCheckOut(new Date());
        alloggio1.setNumeroPersone(2);
        alloggio1.setPrezzoPerNotte(100.0);
        risultatiRicerca.add(alloggio1);

        // Aggiungi altri dati di esempio...

        return risultatiRicerca;
    }
}
