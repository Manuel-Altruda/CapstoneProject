package com.WorldInPocket.Spring.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.CambioValuta;

public interface CambioValutaRepository extends JpaRepository<CambioValuta, Long> {
	
	List<CambioValuta> findByValutaDaAndValutaA(String valutaDa, String valutaA);
	
	List<CambioValuta> findByTassoCambioGreaterThan(double tasso);

	List<CambioValuta> findByValutaDaOrValutaA(String valutaDa, String valutaA);

	List<CambioValuta> findByValutaDaAndValutaAOrderByTassoCambioAsc(String valutaDa, String valutaA);

	List<CambioValuta> findByTassoCambioBetween(double tassoMinimo, double tassoMassimo);

	
	
}
