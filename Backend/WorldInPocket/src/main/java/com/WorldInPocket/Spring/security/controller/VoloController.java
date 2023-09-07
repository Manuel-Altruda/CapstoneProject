package com.WorldInPocket.Spring.security.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.Volo;
import com.WorldInPocket.Spring.security.service.VoloService;

@RestController
@RequestMapping("/api/voli")
public class VoloController {

	@Autowired
    private VoloService voloService;

    @GetMapping("/cerca")
    public ResponseEntity<List<Volo>> cercaVoli(
            @RequestParam String destinazione,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPartenza,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataArrivo,
            @RequestParam int numeroPasseggeri,
            @RequestParam double budget) {
        List<Volo> risultatiRicerca = voloService.cercaVoli(destinazione, dataPartenza, dataArrivo, numeroPasseggeri, budget);
        return new ResponseEntity<>(risultatiRicerca, HttpStatus.OK);
    }
	
}
