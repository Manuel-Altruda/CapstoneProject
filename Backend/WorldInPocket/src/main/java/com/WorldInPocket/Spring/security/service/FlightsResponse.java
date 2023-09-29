package com.WorldInPocket.Spring.security.service;

import java.io.IOException;
import java.util.List;

import com.WorldInPocket.Spring.security.entity.Volo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FlightsResponse {
	
	private final List<Volo> data;
    private final int total;

    public FlightsResponse(List<Volo> data, int total) {
        this.data = data;
        this.total = total;
    }

    public List<Volo> getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }
    
    public static FlightsResponse fromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, FlightsResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
}
