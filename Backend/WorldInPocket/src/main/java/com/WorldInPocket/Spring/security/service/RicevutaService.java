package com.WorldInPocket.Spring.security.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.concurrent.CancellationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.WorldInPocket.Spring.security.dto.RicevutaDTO;
import com.WorldInPocket.Spring.security.entity.Iricevuta;
import com.WorldInPocket.Spring.security.repository.PrenotazioneAlloggioRepository;
import com.WorldInPocket.Spring.security.repository.RicevutaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RicevutaService {
	
	@Autowired
    private RicevutaRepository ricevutaRep;
    
    @Autowired
    private PrenotazioneAlloggioRepository prenotazioneRep;
    
    @Autowired
    private AuthServiceImpl userSvc;
    
    public Iricevuta get(long id) {
        if (!ricevutaRep.existsById(id)) {
            throw new EntityNotFoundException("Couldn't find this Receipt.");
        }
        return ricevutaRep.findById(id).get();
    }

    public Iricevuta edit(long id, Iricevuta ric) {
        if (!ricevutaRep.existsById(id) || id != ric.getId()) {
            throw new EntityNotFoundException("Couldn't find this Receipt.");
        }
        return ricevutaRep.save(ric);
    }

    public String remove(long id) {
        if (!ricevutaRep.existsById(id)) {
            throw new EntityNotFoundException("Couldn't find this Receipt.");
        }

        checkDeleteTimeLimit(id);

        ricevutaRep.deleteById(id);
        return "Receipt deleted successfully.";
    }

    private void checkDeleteTimeLimit(long id) {
    	PrenotazioneAlloggioRepository prenotazioneStartTime = (PrenotazioneAlloggioRepository) prenotazioneRep.findById(id).get();
        if (Duration.between(LocalDateTime.now(), (Temporal) prenotazioneStartTime).toHours() <= 4) {
            throw new CancellationException("Puoi cancellare questa prenotazione entro 4 ore");
        }
    
    }
    }

	

