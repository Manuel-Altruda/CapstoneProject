package com.WorldInPocket.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.CambioValuta;
import com.WorldInPocket.Spring.security.service.CambioValutaService;

@RestController
@RequestMapping("/api/cambio-valuta")
public class CambioValutaController {

    @Autowired
    private CambioValutaService cambioValutaService;

    @GetMapping
    public ResponseEntity<List<CambioValuta>> getAllCambiValuta() {
        List<CambioValuta> cambiValuta = cambioValutaService.getAllCambiValuta();
        return new ResponseEntity<>(cambiValuta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CambioValuta> getCambioValuta(@PathVariable Long id) {
        CambioValuta cambioValuta = cambioValutaService.getCambioValutaById(id);
        return new ResponseEntity<>(cambioValuta, HttpStatus.OK);
    }

    // Implementa gli endpoint per gestire il cambio valuta
}

