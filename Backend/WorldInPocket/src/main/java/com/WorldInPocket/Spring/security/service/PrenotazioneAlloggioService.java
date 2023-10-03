package com.WorldInPocket.Spring.security.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.WorldInPocket.Spring.security.Request.PrenotazioneAlloggioRequest;

import com.WorldInPocket.Spring.security.entity.Hotel;
//import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;
import com.WorldInPocket.Spring.security.repository.PrenotazioneAlloggioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PrenotazioneAlloggioService {

    @Autowired
    private final PrenotazioneAlloggioRepository prenotazioneAlloggioRepository;
    
    public PrenotazioneAlloggioService(PrenotazioneAlloggioRepository prenotazioneAlloggioRepository) {
        this.prenotazioneAlloggioRepository = prenotazioneAlloggioRepository;
    }
    
    public List<PrenotazioneAlloggio> getPrenotazioniAlloggioUtente(String emailUtente) {
        return prenotazioneAlloggioRepository.findByUtenteEmail(emailUtente);
    }

    public List<PrenotazioneAlloggio> ricercaPrenotazioniAlloggioPerData(Date dataCheckIn) {
        return prenotazioneAlloggioRepository.findByDataCheck(dataCheckIn);
    }

    public PrenotazioneAlloggio createPrenotazioneAlloggio(PrenotazioneAlloggio prenotazioneAlloggio) {
        return prenotazioneAlloggioRepository.save(prenotazioneAlloggio);
    }

    public PrenotazioneAlloggio updatePrenotazioneAlloggio(Long prenotazioneId, PrenotazioneAlloggio nuovaPrenotazione) {
        PrenotazioneAlloggio prenotazioneEsistente = getPrenotazioneAlloggioById(prenotazioneId);
        if (prenotazioneEsistente != null) {
            prenotazioneEsistente.setUtenteEmail(nuovaPrenotazione.getUtenteEmail());
            prenotazioneEsistente.setUtenteEmail(nuovaPrenotazione.getUtenteEmail());

            return prenotazioneAlloggioRepository.save(prenotazioneEsistente);
        }
        return null; 
    }

    public boolean deletePrenotazioneAlloggio(Long id) {
        PrenotazioneAlloggio prenotazioneAlloggio = prenotazioneAlloggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prenotazione di alloggio non trovata con ID: " + id));
        prenotazioneAlloggioRepository.delete(prenotazioneAlloggio);
		return false;
    }

	public List<PrenotazioneAlloggio> getAllPrenotazioniAlloggio() {
		return prenotazioneAlloggioRepository.findAll();
	}

	
	public PrenotazioneAlloggio getPrenotazioneAlloggioById(Long id) {
        Optional<PrenotazioneAlloggio> optionalPrenotazioneAlloggio = prenotazioneAlloggioRepository.findById(id);

        if (optionalPrenotazioneAlloggio.isPresent()) {
            return optionalPrenotazioneAlloggio.get();
        } else {
            throw new EntityNotFoundException("Loading reservation not found with ID: " + id);
        }
    }

//	public PrenotazioneAlloggio prenotaAlloggio(Alloggio alloggio, Date dataCheckIn,
//			Date dataCheckOut, int numeroPersone) {
//		boolean disponibile = isDisponibile(alloggio, dataCheckIn, dataCheckOut);
//
//	    if (disponibile) {
//	        PrenotazioneAlloggio prenotazione = new PrenotazioneAlloggio();
//	        prenotazione.setAlloggio(alloggio);
//	        prenotazione.setDataCheckIn(dataCheckIn);
//	        prenotazione.setDataCheckOut(dataCheckOut);
//	        prenotazione.setNumeroPersone(numeroPersone);
//
//	        return prenotazioneAlloggioRepository.save(prenotazione);
//	    } else {
//	        
//	        return null; 
//	    }
//	}
//	
//	public boolean isDisponibile(Alloggio alloggio, Date dataCheckIn, Date dataCheckOut) {
//		List<PrenotazioneAlloggio> prenotazioni = getPrenotazioniAlloggio(alloggio);
//
//    for (PrenotazioneAlloggio prenotazione : prenotazioni) {
//        Date checkIn = prenotazione.getDataCheckIn();
//        Date checkOut = prenotazione.getDataCheckOut();
//
//        if ((dataCheckIn.after(checkIn) && dataCheckIn.before(checkOut)) ||
//            (dataCheckOut.after(checkIn) && dataCheckOut.before(checkOut)) ||
//            (dataCheckIn.equals(checkIn) || dataCheckOut.equals(checkOut))) {
//            // L'alloggio è già prenotato per alcune delle date specificate
//            return false;
//        }
//    }
//	return false;
//}

	public List<PrenotazioneAlloggio> getPrenotazioniAlloggio(Hotel hotel) {
        
        List<PrenotazioneAlloggio> prenotazioni = prenotazioneAlloggioRepository.findByHotel(hotel);

       
        return prenotazioni;
    }

	public Hotel getPrenotazioniAlloggio() {
		return null;
	}

	public List<PrenotazioneAlloggio> prenotaAlloggio(Hotel prenotazioniAlloggio, Date dataCheckIn, Date dataCheckOut,
			int numeroPersone) {
		List<PrenotazioneAlloggio> prenotazioni = prenotazioneAlloggioRepository.findByHotel(prenotazioniAlloggio);

       
        return prenotazioni;
	}
	
}

