package com.WorldInPocket.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.Request.RicercaAlloggiRequest;
import com.WorldInPocket.Spring.security.Request.RicercaVoliRequest;
import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.Volo;
import com.WorldInPocket.Spring.security.service.RicercaService;

@RestController
@RequestMapping("/api/ricerca")
public class RicercaController {
	
	@Autowired
    private RicercaService ricercaService;

    @PostMapping("/alloggi")
    public ResponseEntity<List<Alloggio>> ricercaAlloggi(@RequestBody RicercaAlloggiRequest request) {
        List<Alloggio> risultatiRicerca = ricercaService.cercaAlloggi(request);
        return new ResponseEntity<>(risultatiRicerca, HttpStatus.OK);
    }

    @PostMapping("/voli")
    public ResponseEntity<List<Volo>> ricercaVoli(@RequestBody RicercaVoliRequest request) {
        List<Volo> risultatiRicerca = ricercaService.cercaVoli(request);
        return new ResponseEntity<>(risultatiRicerca, HttpStatus.OK);
    }
	
}
