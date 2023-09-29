package com.WorldInPocket.Spring.security.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WorldInPocket.Spring.security.entity.HotelData;
import com.WorldInPocket.Spring.security.service.HotelDataService;
import com.opencsv.exceptions.CsvValidationException;

@RestController
public class HotelDataController {

	public List<HotelData> readCsvFile() {
        List<HotelData> hotelDataList = new ArrayList<>();

        try {
            // Specifica il percorso del file CSV
            String csvFilePath = "data_csv/hotels.csv"; // Modifica il percorso

            // Utilizza Resource di Spring per ottenere il percorso del file CSV
            ClassPathResource resource = new ClassPathResource(csvFilePath);

            // Verifica se il file esiste
            if (resource.exists()) {
                InputStream inputStream = resource.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                // ...
                // Resto del codice per il caricamento del file
            } else {
                System.err.println("File CSV non trovato: " + csvFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hotelDataList;
    }
}
        
//        try {
//            // Specifica il percorso del file CSV
//            String csvFilePath = "data_csv:hotels.csv";
//
//            // Leggi il file CSV
//            InputStream inputStream = ResourceUtils.getURL(csvFilePath).openStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//            // Leggi il contenuto del file CSV e crea oggetti HotelData
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] fields = line.split(",");
//                if (fields.length >= 3) {
//                    String nome = fields[0];
//                    String città = fields[1];
//                    double hotelRating = Double.parseDouble(fields[2]);
//                    
//                    // Crea un oggetto HotelData e aggiungilo alla lista
//                    HotelData hotelData = new HotelData(nome, città, hotelRating);
//                    hotelDataList.add(hotelData);
//                }
//            }
//
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return hotelDataList;
//    }
//	

