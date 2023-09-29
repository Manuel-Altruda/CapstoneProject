package com.WorldInPocket.Spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_data")
public class HotelData {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;
	private String address1;
	private String type;
    private String nome;
    private String città;
    private double hotelRating;
    private String locationDescription;
    
    public HotelData() { }
    
    public HotelData(String nome, String città, double hotelRating) {
        this.nome = nome;
        this.città = città;
        this.hotelRating = hotelRating;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }
    
    public double getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(double hotelRating) {
        this.hotelRating = hotelRating;
    }
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	@Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                ", hotelRating=" + hotelRating +
                '}';
    }
    
}
