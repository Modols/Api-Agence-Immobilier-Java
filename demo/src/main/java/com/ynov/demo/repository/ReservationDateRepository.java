package com.ynov.demo.repository;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDateRepository extends JpaRepository<ReservationDate, Long> {

    @Query(value = "SELECT r FROM ReservationDate r where r.id = :#{#id} ")
    ReservationDate findReservationDateById(@Param("id") Long id);
}
