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

import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.service.AlloggioService;

@RestController
@RequestMapping("/api/alloggi")
public class AlloggioController {
	
	@Autowired
	private AlloggioService alloggioService;
	
	@GetMapping
	public List<Alloggio> getAlloggi() {
		return alloggioService.getAlloggi();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Alloggio> getAlloggioById(@PathVariable Long id) {
        Alloggio alloggio = alloggioService.getAlloggioById(id);
        if (alloggio != null) {
            return new ResponseEntity<>(alloggio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Alloggio> createAlloggio(@RequestBody Alloggio alloggio) {
        Alloggio savedAlloggio = alloggioService.createAlloggio(alloggio);
        return new ResponseEntity<>(savedAlloggio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alloggio> updateAlloggio(@PathVariable Long id, @RequestBody Alloggio alloggio) {
        Alloggio updatedAlloggio = alloggioService.updateAlloggio(id, alloggio);
        if (updatedAlloggio != null) {
            return new ResponseEntity<>(updatedAlloggio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlloggio(@PathVariable Long id) {
        boolean deleted = alloggioService.deleteAlloggio(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
