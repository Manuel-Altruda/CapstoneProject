package com.WorldInPocket.Spring.security.service;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.HotelData;
import com.WorldInPocket.Spring.security.repository.HotelDataRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class HotelDataService {
    private final HotelDataRepository hotelDataRepository;

    @Autowired
    public HotelDataService(HotelDataRepository hotelDataRepository) {
        this.hotelDataRepository = hotelDataRepository;
    }

    public void importDataFromCsv(String csvFilePath) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String nome = nextLine[0];
                String città = nextLine[1];
                double hotelRating = Double.parseDouble(nextLine[2]);

                HotelData hotelData = new HotelData(nome, città, hotelRating);
                hotelDataRepository.save(hotelData);
            }
        }
    }
}
