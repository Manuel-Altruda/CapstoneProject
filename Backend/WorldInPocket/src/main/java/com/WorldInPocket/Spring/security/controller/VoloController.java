package com.WorldInPocket.Spring.security.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.Volo;
import com.WorldInPocket.Spring.security.exception.RecordNotFoundException;
import com.WorldInPocket.Spring.security.service.FlightapiClient;
import com.WorldInPocket.Spring.security.service.FlightsResponse;
import com.WorldInPocket.Spring.security.service.VoloService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/voli")
public class VoloController {
	@Autowired
	private VoloService voloService;

    @GetMapping("/cerca-voli")
    public ResponseEntity<List<Volo>> cercaVoli(
            //@RequestParam String trip,
            @RequestParam String origin,
            @RequestParam String destinazione,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCheckIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCheckOut,
            @RequestParam int numeroPasseggeri)
             {
    	
    	List<Volo> risultatiRicerca = voloService.cercaVoli(origin, destinazione, dataCheckIn, dataCheckOut, numeroPasseggeri);
        return new ResponseEntity<>(risultatiRicerca, HttpStatus.OK); 
        }
    
    @GetMapping("/{id}")
    public ResponseEntity<Volo> getVoloById(@PathVariable Long id) {
        Volo volo = voloService.getVoloById(id);
        if (volo != null) {
            return new ResponseEntity<>(volo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
