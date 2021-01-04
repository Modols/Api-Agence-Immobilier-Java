package com.ynov.demo.repository;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplexeRepository extends JpaRepository<Complexe, Long> {
    @Query(value = "SELECT c FROM Complexe c where c.pays = :#{#pays} ")
    List<Complexe> findAllComplexeForAPays(@Param("pays") String pays);

    @Query(value = "SELECT DISTINCT c FROM Complexe c   ")
    List<Complexe> getAllComplexe();

    @Query(value = "SELECT c FROM Complexe c where c.id = :#{#id} ")
    Complexe findComplexeById(@Param("id") Long id);

    @Query(value = "SELECT c.* FROM complexe c JOIN appartement a ON  c.id = a.complexe_id where a.id = :#{#id}", nativeQuery = true)
    Complexe findComplexeIdWithAnAppId(@Param("id") Long id);
}
