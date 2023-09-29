package com.WorldInPocket.Spring.security.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.WorldInPocket.Spring.security.Request.PrenotazioneAlloggioRequest;
//import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;
import com.WorldInPocket.Spring.security.service.PrenotazioneAlloggioService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneAlloggioController {
	
	    @Autowired
	    private PrenotazioneAlloggioService prenotazioneAlloggioService;

	    @GetMapping
	    public ResponseEntity<List<PrenotazioneAlloggio>> getAllPrenotazioniAlloggio() {
	        List<PrenotazioneAlloggio> prenotazioniAlloggio = prenotazioneAlloggioService.getAllPrenotazioniAlloggio();
	        return new ResponseEntity<>(prenotazioniAlloggio, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<PrenotazioneAlloggio> getPrenotazioneAlloggioById(@PathVariable Long id) {
	        PrenotazioneAlloggio prenotazioneAlloggio = prenotazioneAlloggioService.getPrenotazioneAlloggioById(id);
	        if (prenotazioneAlloggio != null) {
	            return new ResponseEntity<>(prenotazioneAlloggio, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<PrenotazioneAlloggio> createPrenotazioneAlloggio(@RequestBody PrenotazioneAlloggio prenotazioneAlloggioRequest) {
	        PrenotazioneAlloggio savedPrenotazione = (PrenotazioneAlloggio) prenotazioneAlloggioService.createPrenotazioneAlloggio(prenotazioneAlloggioRequest);
	        return new ResponseEntity<>(savedPrenotazione, HttpStatus.CREATED);
	    }

	    @GetMapping("/utente/{emailUtente}")
	    public ResponseEntity<List<PrenotazioneAlloggio>> getPrenotazioniAlloggioUtente(@PathVariable String emailUtente) {
	        List<PrenotazioneAlloggio> prenotazioniUtente = prenotazioneAlloggioService.getPrenotazioniAlloggioUtente(emailUtente);
	        if (!prenotazioniUtente.isEmpty()) {
	            return new ResponseEntity<>(prenotazioniUtente, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<PrenotazioneAlloggio> updatePrenotazioneAlloggio(@PathVariable Long id, @RequestBody PrenotazioneAlloggio prenotazioneAlloggio) {
	        PrenotazioneAlloggio updatedPrenotazione = prenotazioneAlloggioService.updatePrenotazioneAlloggio(id, prenotazioneAlloggio);
	        if (updatedPrenotazione != null) {
	            return new ResponseEntity<>(updatedPrenotazione, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePrenotazioneAlloggio(@PathVariable Long id) {
	        boolean deleted = prenotazioneAlloggioService.deletePrenotazioneAlloggio(id);
	        if (deleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @PostMapping("/prenotazione")
	    public ResponseEntity<String> prenotaAlloggio(
	            @RequestBody PrenotazioneAlloggioService request,
	            @RequestParam("dataCheckIn") Date dataCheckIn,
	            @RequestParam("dataCheckOut") Date dataCheckOut,
	            @RequestParam("numeroPersone") int numeroPersone
	    ) {
	        List<PrenotazioneAlloggio> nuovaPrenotazione = prenotazioneAlloggioService.prenotaAlloggio(
	                request.getPrenotazioniAlloggio(), dataCheckIn, dataCheckOut, numeroPersone);

	        if (nuovaPrenotazione != null) {
	            return ResponseEntity.ok("Prenotazione effettuata con successo");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossibile effettuare la prenotazione");
	        }
	    }
	    
	    
	}

    
    
 



