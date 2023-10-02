package com.WorldInPocket.Spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.Request.RicercaAlloggiRequest;
import com.WorldInPocket.Spring.security.Request.RicercaVoliRequest;
import com.WorldInPocket.Spring.security.entity.Hotel;
import com.WorldInPocket.Spring.security.entity.Volo;

@Service
public class RicercaService {

//	@Autowired
//    private AlloggioProviderClient alloggioProviderClient;
//	
//    @Autowired
//    private VoloProviderClient voloProviderClient;

	/*da continuare*/
    public List<Hotel> cercaAlloggi(RicercaAlloggiRequest request) {
		return null;
    }

    public List<Volo> cercaVoli(RicercaVoliRequest request) {
		return null;
    }

	
}
