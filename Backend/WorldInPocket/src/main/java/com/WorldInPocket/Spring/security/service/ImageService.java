package com.WorldInPocket.Spring.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.dto.ImageDto;
import com.WorldInPocket.Spring.security.entity.ImageEntity;
import com.WorldInPocket.Spring.security.repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
    private ImageRepository imageRepository;
	
    public byte[] getImageById(Long imageId) {
        Optional<ImageEntity> imageOptional = imageRepository.findById(imageId);
        
        if (imageOptional.isPresent()) {
            return imageOptional.get().getImageBytes();
        } else {
            return null;
        }
    }
    
    
    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }
    
    
    public void saveImage(ImageEntity image) {
        imageRepository.save(image);
    }
}
