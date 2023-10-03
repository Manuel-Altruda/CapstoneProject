package com.WorldInPocket.Spring.security.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DettagliPrenotazione {
	private String name;
	private String email;
	private String phone;
	private String street;
	private int streetNumber;
	private String city;
	private int postCode;
	private String country;
	private LocalDate arrive;
	private LocalDate depart;
	private int people;
	private String bedding;
	private String roomType;
	private String comments;
}
