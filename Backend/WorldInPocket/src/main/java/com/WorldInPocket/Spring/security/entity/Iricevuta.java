package com.WorldInPocket.Spring.security.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.dao.DataIntegrityViolationException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@ToString
@Table(name = "iricevuta") 
public class Iricevuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "iricevuta", cascade = CascadeType.ALL)
    private Set<PrenotazioneAlloggio> prenotazioni = new HashSet<>(); 

    @Column(nullable = false, updatable = false)
    private LocalDateTime captureTime;

    @Column(nullable = false)
    private Double totPrice;

    
    public Iricevuta() {
        this.prenotazioni = new HashSet<>();
    }
    
    
    public void setUser(User user) {
        if (user != null) {
            this.user = user;
        } else {
            throw new DataIntegrityViolationException("Specifica il cliente per questa ricevuta.");
        }
    }

    public void setPrenotazioni(Set<PrenotazioneAlloggio> set) {
        this.prenotazioni = set;
        for (PrenotazioneAlloggio p : set) {
            p.setIricevuta(this);
        }

        double totPrice = calcolaTotalePrezzo(set);
        this.totPrice = totPrice;

        this.captureTime = LocalDateTime.now();
    }

   
    private double calcolaTotalePrezzo(Set<PrenotazioneAlloggio> set) {
        
        double totale = 0.0;
        for (PrenotazioneAlloggio prenotazione : set) {
            totale += prenotazione.calcolaPrezzo();
        }
        return totale;
    }
}
