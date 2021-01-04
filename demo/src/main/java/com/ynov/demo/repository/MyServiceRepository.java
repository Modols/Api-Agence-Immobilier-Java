package com.ynov.demo.repository;

import com.ynov.demo.domain.MyService;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyServiceRepository extends JpaRepository<MyService, Long> {
    @Query(value = "SELECT s FROM MyService s where s.id = :#{#id} ")
    MyService findServiceById(@Param("id") Long id);

    @Query(value = "SELECT DISTINCT s FROM MyService s ")
    List<MyService> getAllServices();
}
