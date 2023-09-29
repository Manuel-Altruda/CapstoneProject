package com.WorldInPocket.Spring.security.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.Booking;
import com.WorldInPocket.Spring.security.entity.PrenotazioneVolo;
import com.WorldInPocket.Spring.security.exception.RecordNotFoundException;
import com.WorldInPocket.Spring.security.service.PrenotazioneVoloService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/booking")
public class PrenotazioneVoloController {  
	PrenotazioneVoloService prenotazioneVoloService;
	
    @GetMapping
    public ResponseEntity<List<PrenotazioneVolo>> getAllPrenotazioniVolo() {
        
		List<PrenotazioneVolo> prenotazioniVolo = prenotazioneVoloService.getAllPrenotazioniVolo();
        return new ResponseEntity<>(prenotazioniVolo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrenotazioneVolo> getPrenotazioneVolo(@PathVariable Long id) {
        PrenotazioneVolo prenotazioneVolo = prenotazioneVoloService.getPrenotazioneVoloById(id);
        return new ResponseEntity<>(prenotazioneVolo, HttpStatus.OK);
    }

    /* Devo Implementare altri endpoint */
}

