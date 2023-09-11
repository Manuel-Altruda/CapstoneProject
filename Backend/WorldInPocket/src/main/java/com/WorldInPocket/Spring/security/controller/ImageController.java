package com.WorldInPocket.Spring.security.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.WorldInPocket.Spring.security.dto.ImageDto;
import com.WorldInPocket.Spring.security.entity.ImageEntity;
import com.WorldInPocket.Spring.security.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	@Autowired
    private ImageService imageService; 

    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long imageId) {
        
        byte[] imageData = imageService.getImageById(imageId);

        if (imageData != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
    @GetMapping ("/all")
    public List<ImageEntity> getAllImages() {
        // Recupera le informazioni delle immagini dal tuo database o da una risorsa esterna
        // Crea oggetti ImageDto con i dati dell'immagine e restituiscili come JSON
        List<ImageEntity> images = imageService.getAllImages();
        return images;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            ImageEntity image = new ImageEntity();
            image.setImageName(file.getOriginalFilename());
            image.setImageBytes(file.getBytes());
            imageService.saveImage(image);

            return ResponseEntity.status(HttpStatus.OK).body("Immagine caricata con successo.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento dell'immagine.");
        }
    }
    
    
}
