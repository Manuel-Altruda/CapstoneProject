package com.WorldInPocket.Spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.dto.RisultatoRicercaAlloggiDTO;
import com.WorldInPocket.Spring.security.dto.RisultatoRicercaVoliDTO;
import com.WorldInPocket.Spring.security.entity.Alloggio;
import com.WorldInPocket.Spring.security.entity.Volo;

@Service
public class RisultatoRicercaService {

	public List<RisultatoRicercaAlloggiDTO> mapToAlloggiDTO(List<Alloggio> alloggi) {
     
        List<RisultatoRicercaAlloggiDTO> alloggiDTO = new ArrayList<>();
        for (Alloggio alloggio : alloggi) {
            RisultatoRicercaAlloggiDTO dto = new RisultatoRicercaAlloggiDTO();
            dto.setId(alloggio.getId());
            dto.setNome(alloggio.getNome());
            dto.setDescrizione(alloggio.getDescrizione());
            dto.setPrezzoPerNotte(alloggio.getPrezzoPerNotte());
            alloggiDTO.add(dto);
        }
        return alloggiDTO;
    }

    public List<RisultatoRicercaVoliDTO> mapToVoliDTO(List<Volo> voli) {
    	List<RisultatoRicercaVoliDTO> voliDTO = new ArrayList<>();

        for (Volo volo : voli) {
            
            RisultatoRicercaVoliDTO dto = new RisultatoRicercaVoliDTO();

            dto.setId(volo.getId());
            dto.setNome(volo.getCompagniaAerea());
            dto.setDescrizione(volo.getDescrizione());
            dto.setPrezzo(volo.getPrezzo());

            voliDTO.add(dto);
        }

        return voliDTO;
    }
	
}
