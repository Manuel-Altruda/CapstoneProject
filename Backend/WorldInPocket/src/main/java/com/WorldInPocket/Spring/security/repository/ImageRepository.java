package com.WorldInPocket.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WorldInPocket.Spring.security.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
	
	
}

