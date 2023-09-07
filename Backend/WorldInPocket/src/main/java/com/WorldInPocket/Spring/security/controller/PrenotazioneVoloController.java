package com.WorldInPocket.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.PrenotazioneVolo;
import com.WorldInPocket.Spring.security.service.PrenotazioneVoloService;

@RestController
@RequestMapping("/api/prenotazioni/voli")
public class PrenotazioneVoloController {

    @Autowired
    private PrenotazioneVoloService prenotazioneVoloService;

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

    // Implementa gli endpoint per gestire le prenotazioni di volo
}

