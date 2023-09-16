package com.WorldInPocket.Spring.security.controller;

import java.util.List;
import java.util.Optional;

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

import com.WorldInPocket.Spring.security.entity.Viaggio;
import com.WorldInPocket.Spring.security.repository.ViaggioRepository;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable Long id) {
        Optional<Viaggio> viaggio = viaggioRepository.findById(id);
        if (viaggio.isPresent()) {
            return new ResponseEntity<>(viaggio.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Viaggio> createViaggio(@RequestBody Viaggio viaggio) {
        Viaggio savedViaggio = viaggioRepository.save(viaggio);
        return new ResponseEntity<>(savedViaggio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viaggio> updateViaggio(@PathVariable Long id, @RequestBody Viaggio viaggio) {
        if (!viaggioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        viaggio.setId(id);
        Viaggio updatedViaggio = viaggioRepository.save(viaggio);
        return new ResponseEntity<>(updatedViaggio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaggio(@PathVariable Long id) {
        if (!viaggioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        viaggioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

