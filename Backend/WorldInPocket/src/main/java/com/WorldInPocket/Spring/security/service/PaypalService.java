package com.WorldInPocket.Spring.security.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.WorldInPocket.Spring.security.dto.RicevutaDTO;
import com.WorldInPocket.Spring.security.entity.Iricevuta;

import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class PaypalService {
	private final String apiBaseUrl="https://api-m.sandbox.paypal.com";
	
	@Value("${paypal.clientId}")
    private String clientId;

    @Value("${paypal.secret}")
    private String clientSecret;
    
    @Autowired private AuthServiceImpl userService;
	
//    private final PrenotazioneService prenotazioneService;
//    private final UserService userService;
//
//    
//    public PaypalService(PrenotazioneService prenotazioneService, UserService userService) {
//        this.prenotazioneService = prenotazioneService;
//        this.userService = userService;
//    }
    
	public String getAccessToken () {
		
		try {
			
            final String tokenApi = apiBaseUrl + "/v1/oauth2/token";

            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(clientId, clientSecret);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<String> request = new HttpEntity<>("grant_type=client_credentials", headers);
            System.out.println(request);
            ResponseEntity<String> response = new RestTemplate().exchange(tokenApi, HttpMethod.POST, request, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            return jsonNode.get("access_token").asText();
        } catch (JsonProcessingException e) {
            throw new DataIntegrityViolationException("Couldn't get the access token.");
        }
	}	
	
	public String createOrder(RicevutaDTO ric) {
		System.out.println(ric.getUser());
		
        try {
            Iricevuta ricevuta=new Iricevuta();
            ricevuta.setPrenotazioni(ric.getPrenotazioni());
            ricevuta.setUser(userService.getUserByEmailOrPassword(ric.getUser().getUsername()));
            ricevuta.setTotPrice(calculateTotalPrice(ricevuta));
            String accessToken = getAccessToken();
           
            final String url=apiBaseUrl+"/v2/checkout/orders";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(accessToken);

            String body = "{\n" +
	                "  \"intent\": \"CAPTURE\",\n" +
	                "  \"purchase_units\": [\n" +
	                "    {\n" +
	                "      \"amount\": {\n" +
	                "        \"currency_code\": \"USD\",\n" +
	                "        \"value\": \"" + ricevuta.getTotPrice() + "\"\n" +
	                "      }\n" +
	                "    }\n" +
	                "  ]\n" +
	                "}";

            HttpEntity<String> request = new HttpEntity<String>(body, headers);
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            System.out.println(jsonNode);
            return jsonNode.get("id").asText();
        }catch (JsonProcessingException e) {
            throw new DataIntegrityViolationException("Error creating the order.");
        }
    }
	
	private double calculateTotalPrice(Iricevuta receipt) {
	    double total = 0.0;

	    Set<PrenotazioneAlloggio> prenotazioni = receipt.getPrenotazioni();

	    for (PrenotazioneAlloggio prenotazione : prenotazioni) {
	        total += prenotazione.calcolaPrezzo();
	    }

	    return total;
	}
	
	public String captureOrder(String orderId) {
        String accessToken=getAccessToken();
        final String url=apiBaseUrl+"/v2/checkout/orders/"+orderId+"/capture";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST, request, String.class);
        return response.getBody();
    }
	
}
