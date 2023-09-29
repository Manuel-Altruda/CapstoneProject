//package com.WorldInPocket.Spring.security.repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.WorldInPocket.Spring.security.entity.Ordine;
//
//
//@Repository
//public interface OrdineRepository extends JpaRepository<Ordine, Long> {
//	List<Ordine> findByAcquirenteId(Long acquirenteId); 
//    List<Ordine> findByStato(String stato);
//    List<Ordine> findByAcquirenteIdAndStato(Long acquirenteId, String stato); 
//
//    
//    List<Ordine> findByAcquirenteIdAndDataOrdineBetween(Long acquirenteId, LocalDate dataInizio, LocalDate dataFine);
//}
