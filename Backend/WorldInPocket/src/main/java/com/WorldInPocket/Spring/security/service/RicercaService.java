package com.WorldInPocket.Spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.Request.RicercaAlloggiRequest;
import com.WorldInPocket.Spring.security.Request.RicercaVoliRequest;
import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.Volo;

@Service
public class RicercaService {

//	@Autowired
//    private AlloggioProviderClient alloggioProviderClient;
//	
//    @Autowired
//    private VoloProviderClient voloProviderClient;

    public List<Alloggio> cercaAlloggi(RicercaAlloggiRequest request) {
		return null;
        // Esegui la ricerca di alloggi utilizzando il client AlloggioProviderClient
    }

    public List<Volo> cercaVoli(RicercaVoliRequest request) {
		return null;
        // Esegui la ricerca di voli utilizzando il client VoloProviderClient
    }

	
}
