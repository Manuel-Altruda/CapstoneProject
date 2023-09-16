package com.WorldInPocket.Spring.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.Viaggio;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {

	List<Viaggio> findAll();

	Optional<Viaggio> findById(Long id);

	Viaggio save(Viaggio viaggio);

	boolean existsById(Long id);

	void deleteById(Long id);

}
