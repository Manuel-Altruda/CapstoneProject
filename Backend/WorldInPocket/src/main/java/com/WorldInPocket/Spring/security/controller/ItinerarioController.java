package com.WorldInPocket.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.Itinerario;
import com.WorldInPocket.Spring.security.service.ItinerarioService;

@RestController
@RequestMapping("/api/itinerari")
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    @GetMapping
    public ResponseEntity<List<Itinerario>> getAllItinerari() {
        List<Itinerario> itinerari = itinerarioService.getAllItinerari();
        return new ResponseEntity<>(itinerari, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerario> getItinerario(@PathVariable Long id) {
        Itinerario itinerario = itinerarioService.getItinerarioById(id);
        return new ResponseEntity<>(itinerario, HttpStatus.OK);
    }

}

