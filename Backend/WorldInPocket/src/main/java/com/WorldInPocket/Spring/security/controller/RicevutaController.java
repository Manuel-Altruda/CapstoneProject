package com.WorldInPocket.Spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.dto.RicevutaDTO;
import com.WorldInPocket.Spring.security.entity.Iricevuta;
import com.WorldInPocket.Spring.security.service.RicevutaService;

@RestController
@RequestMapping("/ricevuta")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RicevutaController {
	@Autowired private RicevutaService ricevutaSvc;


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return new ResponseEntity<Iricevuta>(ricevutaSvc.get(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable long id) {
        return new ResponseEntity<String>(ricevutaSvc.remove(id), HttpStatus.OK);
    }
}
