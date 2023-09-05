package com.WordInPocket.Spring.security.repository;

import java.util.List;

import com.WordInPocket.Spring.security.entity.CambioValuta;

public interface CambioValutaRepository {
	
	List<CambioValuta> findByValutaDaAndValutaA(String valutaDa, String valutaA);
	
	List<CambioValuta> findByTassoCambioGreaterThan(double tasso);

	List<CambioValuta> findByValutaDaOrValutaA(String valutaDa, String valutaA);

	List<CambioValuta> findByValutaDaAndValutaAOrderByTassoCambioAsc(String valutaDa, String valutaA);

	List<CambioValuta> findByTassoCambioBetween(double tassoMinimo, double tassoMassimo);

	
	
}
