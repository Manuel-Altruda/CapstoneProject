package com.WorldInPocket.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.AzioneUtente;

import java.util.List;

public interface AzioneUtenteRepository extends JpaRepository<AzioneUtente, Long> {
    List<AzioneUtente> findByOggettoId(Long oggettoId);
}

