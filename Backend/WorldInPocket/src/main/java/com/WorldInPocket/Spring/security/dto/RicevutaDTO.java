package com.WorldInPocket.Spring.security.dto;

import java.util.List;
import java.util.Set;

import com.WorldInPocket.Spring.security.entity.Hotel;
import com.WorldInPocket.Spring.security.entity.PrenotazioneAlloggio;
import com.WorldInPocket.Spring.security.entity.User;
import com.WorldInPocket.Spring.security.payload.JWTAuthResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RicevutaDTO {
	private Hotel hotel;
	private User user;
	private DettagliPrenotazione details;
	
	public Set<PrenotazioneAlloggio> getPrenotazioni() {

		return null ;
	}
}
