package com.WorldInPocket.Spring.security.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;
import com.WorldInPocket.Spring.security.service.PrenotazioneAlloggioService;

@RestController
@RequestMapping("/api/prenotazione-alloggi")
public class PrenotazioneAlloggioController {

    @Autowired
    private PrenotazioneAlloggioService prenotazioneAlloggioService;

    @GetMapping
    public ResponseEntity<List<PrenotazioneAlloggio>> getAllPrenotazioniAlloggio() {
        List<PrenotazioneAlloggio> prenotazioniAlloggio = prenotazioneAlloggioService.getAllPrenotazioniAlloggio();
        return new ResponseEntity<>(prenotazioniAlloggio, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrenotazioneAlloggio> getPrenotazioneAlloggio(@PathVariable Long id) {
        PrenotazioneAlloggio prenotazioneAlloggio = prenotazioneAlloggioService.getPrenotazioneAlloggioById(id);
        return new ResponseEntity<>(prenotazioneAlloggio, HttpStatus.OK);
    }
    
//    @PostMapping("/nuova-prenotazione")
//    public ResponseEntity<String> prenotaAlloggio(
//            @RequestBody PrenotazioneAlloggioService request,
//            @RequestParam("dataCheckIn") Date dataCheckIn,
//            @RequestParam("dataCheckOut") Date dataCheckOut,
//            @RequestParam("numeroPersone") int numeroPersone
//    ) {
//        PrenotazioneAlloggio nuovaPrenotazione = prenotazioneAlloggioService.prenotaAlloggio(
//                request.getPrenotazioniAlloggio(), dataCheckIn, dataCheckOut, numeroPersone);
//
//        if (nuovaPrenotazione != null) {
//            return ResponseEntity.ok("Prenotazione effettuata con successo");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossibile effettuare la prenotazione");
//        }
//    }
// 

}

