package com.WordInPocket.Spring.security.repository;

import java.util.Date;
import java.util.List;

import com.WordInPocket.Spring.security.entity.ConsiglioViaggio;

public interface ConsiglioViaggioRepository {

	List<ConsiglioViaggio> findByAutore(String autore);

	List<ConsiglioViaggio> findByTitoloContaining(String keyword);

	List<ConsiglioViaggio> findByDataPubblicazioneAfter(Date data);

	List<ConsiglioViaggio> findByTestoContaining(String keyword);

	List<ConsiglioViaggio> findByAutoreAndTitolo(String autore, String titolo);

}
