package com.WorldInPocket.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.Visita;

import java.util.List;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
    List<Visita> findByDestinazioneId(Long destinazioneId);
}

