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
@RequestMapping("/flight")
public class VoloController {
	
	private VoloService voloService;
	private final FlightapiClient flightapiClient;
	
	 public VoloController(FlightapiClient flightapiClient) {
	        this.flightapiClient = flightapiClient;
	    }

    @GetMapping("/cerca-voli")
    public ResponseEntity<List<Volo>> cercaVoli(
            @RequestParam String destinazione,
            @RequestParam  LocalDate dataCheckIn,
            @RequestParam  LocalDate dataCheckOut,
            @RequestParam int numeroPasseggeri,
            @RequestParam(name = "prezzo", required = false, defaultValue = "0.0") double prezzo) {
    	FlightsResponse flightsResponse = null;
		try {
			flightsResponse = flightapiClient.getFlights("ROM", "LON");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
    	List<Volo> voli = flightsResponse.getData().stream().map(flight -> new Volo(
    			flight.getOrigin(),
                flight.getCompagniaAerea(),
                flight.getNumeroVolo(),
                flight.getDestinazione(),
                flight.getDescrizione(),
                flight.getDataCheckIn(),
                flight.getDataCheckOut(),
                flight.getNumeroPasseggeri(),
                flight.getPrezzo()
        )).collect(Collectors.toList());
    	
    	List<Volo> risultatiRicerca = voloService.cercaVoli(destinazione, dataCheckIn, dataCheckOut, numeroPasseggeri,prezzo);
        return new ResponseEntity<>(risultatiRicerca, HttpStatus.OK);
    }
	
}
