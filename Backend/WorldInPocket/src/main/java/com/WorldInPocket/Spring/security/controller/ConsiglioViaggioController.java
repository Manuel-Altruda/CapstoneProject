package com.WorldInPocket.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.ConsiglioViaggio;
import com.WorldInPocket.Spring.security.service.ConsiglioViaggioService;

@RestController
@RequestMapping("/api/consigli-viaggio")
public class ConsiglioViaggioController {

    @Autowired
    private ConsiglioViaggioService consiglioViaggioService;

    @GetMapping
    public ResponseEntity<List<ConsiglioViaggio>> getAllConsigliViaggio() {
        List<ConsiglioViaggio> consigliViaggio = consiglioViaggioService.getAllConsigliViaggio();
        return new ResponseEntity<>(consigliViaggio, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsiglioViaggio> getConsiglioViaggio(@PathVariable Long id) {
        ConsiglioViaggio consiglioViaggio = consiglioViaggioService.getConsiglioViaggioById(id);
        return new ResponseEntity<>(consiglioViaggio, HttpStatus.OK);
    }

}

