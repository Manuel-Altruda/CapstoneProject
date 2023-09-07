package com.WorldInPocket.Spring.security.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.Destinazione;
import com.WorldInPocket.Spring.security.service.DestinazioneService;

@RestController
@RequestMapping("/api/destinazioni")
public class DestinazioneController {

    @Autowired
    private DestinazioneService destinazioneService;

    @GetMapping
    public ResponseEntity<List<Destinazione>> getAllDestinazioni() {
        List<Destinazione> destinazioni = destinazioneService.getAllDestinazioni();
        return new ResponseEntity<>(destinazioni, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destinazione> getDestinazione(@PathVariable Long id) {
        Destinazione destinazione = destinazioneService.getDestinazioneById(id);
        return new ResponseEntity<>(destinazione, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Destinazione> createDestinazione(@RequestBody Destinazione destinazione) {
        Destinazione createdDestinazione = destinazioneService.createDestinazione(destinazione);
        return new ResponseEntity<>(createdDestinazione, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destinazione> updateDestinazione(@PathVariable Long id, @RequestBody Destinazione destinazione) {
        Destinazione updatedDestinazione = destinazioneService.updateDestinazione(id, destinazione);
        return new ResponseEntity<>(updatedDestinazione, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestinazione(@PathVariable Long id) {
        destinazioneService.deleteDestinazione(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
