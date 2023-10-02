package com.WorldInPocket.Spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.dto.RicevutaDTO;
import com.WorldInPocket.Spring.security.entity.User;
import com.WorldInPocket.Spring.security.repository.UserRepository;
import com.WorldInPocket.Spring.security.service.PaypalService;


@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PayPalController {
	
	@Autowired private PaypalService payPalService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> create(@RequestBody RicevutaDTO r) {
        return new ResponseEntity<String>(payPalService.createOrder(r), HttpStatus.CREATED);
    }

    @PostMapping("/{orderId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> create(@PathVariable String orderId) {
        return new ResponseEntity<String>(payPalService.captureOrder(orderId), HttpStatus.CREATED);
    }	
}
