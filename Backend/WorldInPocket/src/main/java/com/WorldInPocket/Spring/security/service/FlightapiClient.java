package com.WorldInPocket.Spring.security.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public class FlightapiClient {
	
	private final HttpClient httpClient;

    public FlightapiClient() {
        httpClient = HttpClient.newBuilder().build();
    }

    public FlightsResponse getFlights(String origin, String destination) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.flightapi.io/onewaytrip?origin=" + origin + "&destination=" + destination))
                .header("Authorization", "Bearer 6501f56d9b605a57eb792907")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Errore durante la richiesta all'API: " + response.statusCode());
        }

        return FlightsResponse.fromJson(response.body());
    }
	
    
    
    
}
