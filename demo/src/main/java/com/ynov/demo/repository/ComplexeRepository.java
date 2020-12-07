package com.ynov.demo.repository;

import com.ynov.demo.domain.Complexe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplexeRepository extends JpaRepository<Complexe, Long> {
    @Query(value = "SELECT c FROM Complexe c JOIN FETCH c.appartements ")
    List<Complexe> getComplexeWithAppartements();
}
