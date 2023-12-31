package com.WorldInPocket.Spring.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.CambioValuta;
import com.WorldInPocket.Spring.security.repository.CambioValutaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CambioValutaService {

    @Autowired
    private CambioValutaRepository cambioValutaRepository;

    public double convertiValuta(double importo, String valutaDa, String valutaA) throws Exception {
        CambioValuta cambioValuta = (CambioValuta) cambioValutaRepository.findByValutaDaAndValutaA(valutaDa, valutaA);
        if (cambioValuta == null) {
            throw new Exception("Tasso di cambio non disponibile per la coppia di valute: " + valutaDa + "/" + valutaA);
        }
        return importo * cambioValuta.getTassoCambio();
    }

	public List<CambioValuta> getAllCambiValuta() {
        return cambioValutaRepository.findAll();

	}

	public CambioValuta getCambioValutaById(Long id) {
        
        Optional<CambioValuta> optionalCambioValuta = cambioValutaRepository.findById(id);

        if (optionalCambioValuta.isPresent()) {
            return optionalCambioValuta.get();
        } else {
            
            throw new EntityNotFoundException("Currency exchange rate not found with ID: " + id);
        }
    }

}

