package com.WorldInPocket.Spring.security.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.ConsiglioViaggio;

public interface ConsiglioViaggioRepository extends JpaRepository<ConsiglioViaggio, Long> {

	List<ConsiglioViaggio> findByAutore(String autore);

	List<ConsiglioViaggio> findByTitoloContaining(String keyword);

	List<ConsiglioViaggio> findByDataPubblicazioneAfter(Date data);

	List<ConsiglioViaggio> findByTestoContaining(String keyword);

	List<ConsiglioViaggio> findByAutoreAndTitolo(String autore, String titolo);

	ConsiglioViaggio save(ConsiglioViaggio consiglioViaggio);

	Optional<ConsiglioViaggio> findById(Long id);

}
