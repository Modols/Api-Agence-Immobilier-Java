package com.ynov.demo.repository;

import com.ynov.demo.domain.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
//    Appartement findByRegistration(String id);

    @Query(value = "SELECT * FROM Appartement a ", nativeQuery = true)
    List<Appartement>  findWithAllArguments();
}
