package com.ynov.demo.repository;

import com.ynov.demo.domain.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
//    Appartement findByRegistration(String id);
}
