package com.ynov.demo.repository;

import com.ynov.demo.domain.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
//    Appartement findByRegistration(String id);

//    Appartement findById(Long id);

    @Query(value = "SELECT a FROM Appartement a where a.id = :#{#id} ")
    Appartement findAppId(@Param("id") Long id);

    @Query(value = "SELECT a.* FROM appartement a JOIN complexe c ON a.complexe_id = c.id \n" +
            "WHERE a.complexe_id = :#{#id}", nativeQuery = true)
    List<Appartement> findAppartementsWithComplexeId(@Param("id") Long id);


//    @Query(value = "select * FROM  appartement a JOIN complexe c ON a.complexe_id = c.id", nativeQuery = true)
//    List<Appartement>  findWithAllArguments();
}

