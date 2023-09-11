package com.WorldInPocket.Spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.Recensione;
import com.WorldInPocket.Spring.security.service.RecensioneService;

@RestController
@RequestMapping("/api/recensioni")
public class RecensioneController {
	
	@Autowired
	private RecensioneService recensioneService;
	
	@PostMapping
	public ResponseEntity<Recensione> createRecensione(@RequestBody Recensione recensione) {
		Recensione savedRecensione = recensioneService.createRecensione(recensione);
        return new ResponseEntity<>(savedRecensione, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Recensione> getRecensioneById(@PathVariable Long id) {
        Recensione recensione = recensioneService.getRecensioneById(id);
        if (recensione != null) {
            return new ResponseEntity<>(recensione, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
